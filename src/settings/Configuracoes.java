package settings;
public class Configuracoes {

	private int frameWidth;
	private int frameHeight;
        private int menuHeight;
	private int tamanhoJogador;
	private double accel;
	private double bounce;
	private double friction;
        
        
    private static final int DEF_FRAME_WIDTH = 800;
    private static final int DEF_FRAME_HEIGHT = 800;
    private static final int DEF_TAMANHO_JOGADOR = 30;
    private static final int DEF_MAX_BULLETS = 6;
    private static final double DEF_ACCEL = 0.05;	
    private static final double DEF_FRICTION = 0.0035;
    private static final int BULLET_LIFESPAN = 200;
    private static final double BULLET_SPEED = 5;
   

	public Configuracoes() {
		frameWidth = DEF_FRAME_WIDTH;
		frameHeight = DEF_FRAME_HEIGHT;
		tamanhoJogador = DEF_TAMANHO_JOGADOR;
		accel = DEF_ACCEL;
		friction = DEF_FRICTION;
	}

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public int getMenuHeight() {
        return menuHeight;
    }

    public int getTamanhoJogador() {
        return tamanhoJogador;
    }

    public double getAccel() {
        return accel;
    }

    public double getBounce() {
        return bounce;
    }

    public double getFriction() {
        return friction;
    }

    public int maxBullets() {
        return DEF_MAX_BULLETS;
    }

    public int getBulletLifespan() {
	    return BULLET_LIFESPAN;
    }

    public double getBulletSpeed() {
	    return BULLET_SPEED;
    }


}