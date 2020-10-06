package game;

import javafx.scene.input.KeyCode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import settings.Configuracoes;

import java.util.ArrayList;

public class Nave extends GameObj {

    private double accX;
    private double accY;
    private double accel;

    private double[] navePontosX;
    private double[] navePontosY;

    private ArrayList<Bullet> bullets;

    private boolean turningLeft;
    private boolean turningRight;
    private boolean accelerating;
    private boolean shooting;

    Musica m;
    private Configuracoes c;

    public Nave(Configuracoes c) {
        super(c.getFrameWidth() >> 1, c.getFrameHeight() >> 1, 0, 0, 0, c);        //0, 0, 0 = direita, baixo, esquerda
        this.c = getConfiguracoes();

        bullets = new ArrayList<>();

        accX = 0;
        accY = 0;

        navePontosX = new double[4];               //construindo 4 linhas na nave
        navePontosY = new double[4];
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

    private void setNavePontos() {
        navePontosX[0] = x + (10 * cos);
        navePontosX[1] = x - (10 * cos) - (5 * sin);
        navePontosX[2] = x - (10 * cos) + (5 * sin);
        navePontosX[3] = navePontosX[0];

        navePontosY[0] = y + (10 * sin);
        navePontosY[1] = y + (5 * cos) - (10 * sin);
        navePontosY[2] = y - (5 * cos) - (10 * sin);
        navePontosY[3] = navePontosY[0];
    }

    public void keyPressed(KeyCode key) {
        if (key == KeyCode.LEFT) {
            turningLeft = true;
        }
        if (key == KeyCode.RIGHT) {
            turningRight = true;
        }
        if (key == KeyCode.UP) {
            accelerating = true;
        }
        if (key == KeyCode.SPACE) {
            shooting = true;
        }
    }

    public void keyReleased(KeyCode key) {
        if (key == KeyCode.LEFT) {
            turningLeft = false;
        }
        if (key == KeyCode.RIGHT) {
            turningRight = false;
        }
        if (key == KeyCode.UP) {
            accelerating = false;
        }
        if (key == KeyCode.SPACE) {

            shooting = false;
        }
    }

    private void movimentar() {
        angle -= 3 * (turningLeft ? 1 : 0);         //Se TurningLeft for true vai retornar 1, se não 0
        angle += 3 * (turningRight ? 1 : 0);       //velocidade que a nave gira

        cos = Math.cos(Math.toRadians(angle));
        sin = Math.sin(Math.toRadians(angle));
    }

    private void accelerate() {
        accel = c.getAccel() * (accelerating ? 1 : 0);
    }

    public void shoot() {
        if (!shooting) {

            return;   //se remover, atira sozinho sem apertar
        }
        if (bullets.size() > 0) {

            if (bullets.get(bullets.size() - 1).getAge() > 19) { //getAge a quantidade de balas atiradas

                if (bullets.size() < c.maxBullets()) {
                    bullets.add(new Bullet(getFront(), getSpeed(), this.angle, c));
                    m = new Musica("src/music/tiroasteroid.mp3");
                    m.tocarMusica();
                    m = null;
                } else {
                    bullets.remove(0);
                    bullets.add(new Bullet(getFront(), getSpeed(), this.angle, c));

                }

            }
        }
        if (bullets.size() == 0) {
            bullets.add(new Bullet(getFront(), getSpeed(), this.angle, c));

        }

    }

    private void removeDeadBullets() {
        if (bullets.size() > 0) {

            if (bullets.get(0).isDead()) {
                bullets.remove(0);
            }
        }
    }

    private void move() {
        shoot();
        movimentar();
        accelerate();

        accX = accel * cos;
        accY = accel * sin;

        speedX += accX - speedX * c.getFriction();
        speedY += accY - speedY * c.getFriction();

        x += speedX;
        y += speedY;

        checkBounds();
        setNavePontos();
        removeDeadBullets();
    }

    public void draw(GraphicsContext gc) {
        move();

        gc.setStroke(Color.WHITE);
        for (int i = 0; i < navePontosY.length - 1; i++) {
            gc.strokeLine(navePontosX[i], navePontosY[i], navePontosX[i + 1], navePontosY[i + 1]);
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(gc, c);
        }
    }

    public double[] getFront() {
        double[] front = {navePontosX[0], navePontosY[0]};
        return front;
    }

    public double[] getSpeed() {
        double[] speed = {speedX, speedY};
        return speed;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

}