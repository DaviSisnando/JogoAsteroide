package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import settings.Configuracoes;

import java.util.ArrayList;
import java.util.Random;

public class Asteroid extends GameObj {

    public static int score = 0;

    private double[] asteroidPontosX;
    private double[] asteroidPontosY;
    private double rotationSpeed;

    private int level;
    private double tamanho;

    Musica m;

    public Asteroid(double x, double y, double speedX, double speedY,
            double angle, double rotationSpeed, int level, Configuracoes c) {
        super(x, y, speedX, speedY, angle, c);
        this.rotationSpeed = rotationSpeed;
        this.level = level;
        tamanho = 25 - level * 5;
        asteroidPontosX = new double[7];
        asteroidPontosY = new double[7];
    }

    private void checkBounds() {
        if (x < 0) {
            x = c.getFrameWidth();
        }
        if (x > c.getFrameWidth()) {
            x = 0;
        }
        if (y < 0) {
            y = c.getFrameHeight();
        }
        if (y > c.getFrameHeight()) {
            y = 0;
        }
    }

    private void setAsteroidPontos() {
        for (int i = 0; i < asteroidPontosX.length; i++) {
            asteroidPontosX[i] = x + (tamanho * Math.cos(Math.toRadians(angle + 60 * i)));
            asteroidPontosY[i] = y + (tamanho * Math.sin(Math.toRadians(angle + 60 * i)));
        }
    }

    private void movimentar() {
        angle += rotationSpeed;
        cos = Math.cos(Math.toRadians(angle));
        sin = Math.sin(Math.toRadians(angle));
    }

    public void isHit(ArrayList<Asteroid> asteroids, int index, Random r) {
        if (this.level < 3) {
            for (int j = 0; j < 2; j++) {
                asteroids.add(new Asteroid(x, y, (r.nextDouble() * 4) - 2,
                        (r.nextDouble() * 4) - 2, r.nextDouble() * 360,
                        (r.nextDouble() * 4) - 2, this.level + 1, c));
            }
        }

        asteroids.remove(index);
        m = new Musica("src/music/explosaoasteroid.mp3");
        m.tocarMusica();
        m = null;
    }

    private void move() {
        movimentar();

        x += speedX;
        y += speedY;

        checkBounds();
        setAsteroidPontos();
    }

    public void draw(GraphicsContext gc) {
        move();

        gc.setStroke(Color.WHITE);
        for (int i = 0; i < asteroidPontosX.length - 1; i++) {
            gc.strokeLine(asteroidPontosX[i], asteroidPontosY[i], asteroidPontosX[i + 1], asteroidPontosY[i + 1]);
        }

    }

    public static void drawScore(GraphicsContext gc) {
        gc.setFill(Color.WHITE);

        gc.fillText("Score: " + score, 720, 60);
        gc.setFill(Color.BLACK);
    }

    public double getTamanho() {
        return tamanho;
    }

}
