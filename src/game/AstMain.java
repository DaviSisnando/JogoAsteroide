package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import settings.Configuracoes;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import view.TelaFinal;

public class AstMain extends Application {

    public static Stage stage;
    private static Group root;
    private static Scene scene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static AnimationTimer timer;
    private static Random r;
    private static Configuracoes c;
    private static Nave nave;
    private static ArrayList<Asteroid> asteroids;
    private static ArrayList<Ovni> ovnis;
    private static long tempo;
    ScorePers pers = new ScorePers();
    static Score sa = new Score(0);

    public static int aux = 0;
    public static int aux2 = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public static void telaInicial(Stage stage) {
        root = new Group();
        scene = new Scene(root);

        Menu menu = new Menu();

        root.getChildren().add(menu);

        stage.setScene(scene);
    }

    @Override
    public void start(Stage stage) {

        c = new Configuracoes();
        r = new Random();

        nave = new Nave(c);
        asteroids = new ArrayList<Asteroid>();

        ovnis = new ArrayList<Ovni>();

        for (int i = 0; i < 5; i++) {
            asteroids.add(new Asteroid(r.nextDouble() * c.getFrameWidth(),
                    r.nextDouble() * c.getFrameHeight(),
                    (r.nextDouble() * 4) - 2, (r.nextDouble() * 4) - 2,
                    r.nextDouble() * 360, (r.nextDouble() * 4) - 2,
                    0, c));
        }

        for (int i = 0; i < 3; i++) {
            ovnis.add(new Ovni(r.nextDouble() * c.getFrameWidth(),
                    r.nextDouble() * c.getFrameHeight(),
                    r.nextDouble() * 2, r.nextDouble() * 2, c));
        }

        canvas = new Canvas(c.getFrameWidth(), c.getFrameHeight());
        gc = canvas.getGraphicsContext2D();

        tempo = System.currentTimeMillis();

        timer = new AnimationTimer() {
            @Override
            public void handle(long n) {

                while (System.currentTimeMillis() - tempo < 1) {;
                }

                try {
                    update();
                } catch (Exception ex) {
                    Logger.getLogger(AstMain.class.getName()).log(Level.SEVERE, null, ex);
                }

                tempo = System.currentTimeMillis();
            }
        };
        timer.start();

        root = new Group(canvas);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, c.getFrameWidth(), c.getFrameHeight());

    }

    private static void limpar() {
        gc.setStroke(Color.BLACK);
        gc.fillRect(0, 0, c.getFrameWidth(), c.getFrameHeight());
    }

    private static void asteroidColisao() {
        for (int i = 0; i < asteroids.size(); i++) {
            for (int j = 0; j < nave.getBullets().size(); j++) {
                if ((Math.pow(nave.getBullets().get(j).getX() - asteroids.get(i).getX(), 2)
                        + Math.pow(nave.getBullets().get(j).getY() - asteroids.get(i).getY(), 2)) < Math.pow(asteroids.get(i).getTamanho(), 2)) {
                    nave.getBullets().remove(j);
                    Asteroid.score += 10;
                    sa.score += 10;
                    asteroids.get(i).isHit(asteroids, i, r);
                    return;
                }
            }
        }
    }

    private static void ovniColisao() {
        for (int i = 0; i < ovnis.size(); i++) {
            for (int j = 0; j < nave.getBullets().size(); j++) {
                if ((Math.pow(nave.getBullets().get(j).getX() - ovnis.get(i).getX(), 2)
                        + Math.pow(nave.getBullets().get(j).getY() - ovnis.get(i).getY(), 2)) < Math.pow(ovnis.get(i).getTamanho(), 2)) {
                    nave.getBullets().remove(j);
                    Asteroid.score += 30;
                    sa.score += 30;

                    ovnis.get(i).isHitt(ovnis, i);
                    return;
                }
            }
        }
    }

    public static void naveColisao() throws Exception {
        Musica m;

        for (Asteroid ast : asteroids) {
            if ((Math.pow(nave.getX() - ast.getX(), 2) + Math.pow(nave.getY() - ast.getY(), 2)) < Math.pow(ast.getTamanho(), 2)) {
                aux = 1;
                if (aux2 == 0) {
                    m = new Musica("src/music/explosaojogador1.mp3");
                    m.tocarMusica();
                    m = null;
                    ScorePers.adicionarScore(new Score(sa.score));
                }
                aux2 = 1;
            }
        }
        for (Ovni ov : ovnis) {
            if ((Math.pow(nave.getX() - ov.getX(), 2) + Math.pow(nave.getY() - ov.getY(), 2)) < Math.pow(ov.getTamanho(), 2)) {
                aux = 1;
                if (aux2 == 0) {
                    m = new Musica("src/music/explosaojogador1.mp3");
                    m.tocarMusica();
                    m = null;
                    ScorePers.adicionarScore(new Score(sa.score));
                }
                aux2 = 1;
            }
        }
        if (aux == 1) {

            limpar();
            drawPlacar(gc);
        }
    }

    public static void drawPlacar(GraphicsContext gc) {
        int py = 10;
        gc.setFill(Color.WHITE);

        gc.fillText("MELHORES PONTUAÇÕES: ", 300, 200);
        for (Score s : ScorePers.score) {
            py += 15;
            gc.fillText("" + s.getScore(), 370, 200 + py);

        }
        gc.setFill(Color.BLACK);
    }

    private static void update() throws Exception {
        if (nave != null) {
            scene.setOnKeyPressed(event -> {
                nave.keyPressed(event.getCode());
            });

            scene.setOnKeyReleased(event -> {
                nave.keyReleased(event.getCode());
            });

            limpar();
            asteroidColisao();

            ovniColisao();

            nave.draw(gc);
            naveColisao();
        }
        Asteroid.drawScore(gc);
        for (Asteroid ast : asteroids) {
            ast.draw(gc);
        }

        for (Ovni ov : ovnis) {
            ov.draw(gc);
        }
    }

}
