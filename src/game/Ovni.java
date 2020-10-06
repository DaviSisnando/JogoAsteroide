package game;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import settings.Configuracoes;


public class Ovni extends GameObj{
    public static int score = 0;
    private double[] ovniPontosX;
    private double[] ovniPontosY;
    private double tamanho;

    Musica m;
    
    public Ovni(double x, double y, double speedX, double speedY, Configuracoes c) {
        super(x, y, speedX, speedY, 2, c);
            ovniPontosX = new double[13];
            ovniPontosY = new double[13];
            tamanho = 12;
            
    }
    
    private void checkBounds() {
        if (x < 0) x = c.getFrameWidth();
        if (x > c.getFrameWidth()) x = 0;
        if (y < 0) y = c.getFrameHeight();
        if (y > c.getFrameHeight()) y = 0;
    }
        
    private void setOvniPontos() {
        for (int i = 0; i < ovniPontosX.length; i++) {
        	ovniPontosX[i] = x + (tamanho * Math.cos(Math.toRadians(angle + 30*i)));
           	ovniPontosY[i] = y + (tamanho * Math.sin(Math.toRadians(angle + 30*i)));
        }
    }
        
    private void movimentar() { 
        cos = Math.cos(Math.toRadians(angle));
        sin = Math.sin(Math.toRadians(angle));
    }        
        
    private void move() {
    	movimentar();

    	x += speedX;
    	y += speedY;

    	checkBounds();
    	setOvniPontos();
    }       
        
        
    public void isHitt(ArrayList<Ovni> ovnis, int index) {
        ovnis.remove(index);
        m = new Musica("src/music/explosaoinimigo.mp3");
        m.tocarMusica();
        m = null;
    }
    
    
    
             
    public void draw(GraphicsContext gc) {
        move();

        gc.setStroke(Color.RED);
        for (int i = 0; i < ovniPontosY.length - 1; i++) {
            gc.strokeLine(ovniPontosX[i], ovniPontosY[i], ovniPontosX[i+1], ovniPontosY[i+1]);
        }
    }    
    

    public double getTamanho() {
        return tamanho;
    }
}   
