package game;


import game.AstMain;
import static game.AstMain.stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.lang.*;
import javafx.scene.layout.*;

public class Menu extends AnchorPane {

    protected final Button button;
    protected final Text text;
    protected final Button button0;
    protected final Button button1;

    public Menu() {

        button = new Button();
        text = new Text();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #000;");

        text.setFill(javafx.scene.paint.Color.valueOf("#f5f4f4"));
        text.setLayoutX(157.0);
        text.setLayoutY(155.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ASTEROIDS");
        text.setFont(new Font(96.0));
        
        
        button.setLayoutX(299.0);
        button.setLayoutY(345.0);
        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-color: #000; -fx-text-fill: #fff;");
        button.setText("Start");
        button.setFont(new Font("Bell MT", 60.0));
        
        button.setOnAction(this::handleStart); 

        button0.setLayoutX(299.0);
        button0.setLayoutY(456.0);
        button0.setMnemonicParsing(false);
        button0.setStyle("-fx-background-color: #000; -fx-text-fill: #fff;");
        button0.setText("Score");
        button0.setFont(new Font("Bell MT", 60.0));
        
        
        button1.setLayoutX(299.0);
        button1.setLayoutY(573.0);
        button1.setMnemonicParsing(false);
        button1.setStyle("-fx-background-color: #000; -fx-text-fill: #fff;");
        button1.setText("Quit");
        button1.setFont(new Font("Bell MT", 60.0));

        getChildren().add(button);
        getChildren().add(text);
        getChildren().add(button0);
        getChildren().add(button1);

    }
    
    private void handleStart(javafx.event.ActionEvent actionEvent){
        //AstMain.telaJogo(stage);
    }
    
}
