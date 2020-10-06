package game;

import settings.Configuracoes;

public class GameObj {

	double x;
	double y;
	double speedX;
	double speedY;
	double angle;
	double cos;
        double sin;

        Configuracoes c;


    public GameObj(double x, double y, double speedX, double speedY,
    				double angle, Configuracoes c) {
    	this.x = x;
    	this.y = y;
    	this.speedX = speedX;
    	this.speedY = speedY;
    	this.angle = angle;
    	this.cos = Math.cos(Math.toRadians(angle));
    	this.sin = Math.sin(Math.toRadians(angle));
    	this.c = c;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getAngle() {
        return angle;
    }

    public Configuracoes getConfiguracoes() {
        return c;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        this.cos = Math.cos(Math.toRadians(angle));
        this.sin = Math.sin(Math.toRadians(angle));
    }

    public void setConfiguracoes(Configuracoes c) {
        this.c = c;
    }

}