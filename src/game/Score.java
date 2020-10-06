
package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Score {

    int score = 0;

    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void draw1(GraphicsContext gc) {

        gc.setFill(Color.RED);
        gc.fillText("Score: " + score, 700, 100);
        gc.setFill(Color.BLACK);

    }

    @Override
    public String toString() {
        return "Score{" + this.score + '}';
    }

}
