package game;
import java.applet.AudioClip;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import settings.Configuracoes;

public class Bullet extends GameObj {

	private int framesAlive;
	private Configuracoes c;

	public Bullet(double[] front, double[] shipSpeed, double angle, Configuracoes c) {
		super(front[0], front[1], 0, 0, angle, c);
		this.framesAlive = 0;
		this.c = c;

		setSpeedX(c.getBulletSpeed() * cos + shipSpeed[0]);
		setSpeedY(c.getBulletSpeed() * sin + shipSpeed[1]);
                
	}

	public void draw(GraphicsContext gc, Configuracoes c) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x-1, y-1, 2, 2);
		gc.setFill(Color.BLACK);
		move(c);
	}

	public void move(Configuracoes c) {
		x += speedX;
		y += speedY;

        if (x < 0) x = c.getFrameWidth();           //angulacao que a bala sai
        if (x > c.getFrameWidth()) x = 0;
        if (y < 0) y = c.getFrameHeight();
        if (y > c.getFrameHeight()) y = 0;

        framesAlive++;
	}

	public boolean isDead() {
		return framesAlive >= c.getBulletLifespan();
	}

	public int getAge() {
		return framesAlive;
	}
        
}