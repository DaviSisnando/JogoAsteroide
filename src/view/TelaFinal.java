package view;

import javafx.scene.text.*;
import java.lang.*;
import javafx.scene.layout.*;

public class TelaFinal extends AnchorPane {

    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final Text text4;
    protected final Text text5;
    protected final Text text6;
    protected final Text text7;
    protected final Text text8;
    protected final Text text9;
    protected final Text text10;
    protected final Text text11;
    protected final Text text12;

    public TelaFinal() {

        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        text8 = new Text();
        text9 = new Text();
        text10 = new Text();
        text11 = new Text();
        text12 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #000;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(290.0);
        text.setLayoutY(114.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ASTEROID");
        text.setWrappingWidth(283.880859375);
        text.setFont(new Font(48.0));

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(329.0);
        text0.setLayoutY(227.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("PONTUA��O");
        text0.setFont(new Font(24.0));

        text1.setFill(javafx.scene.paint.Color.WHITE);
        text1.setLayoutX(149.0);
        text1.setLayoutY(333.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("NOME");
        text1.setWrappingWidth(57.58642578125);
        text1.setFont(new Font(18.0));

        text2.setFill(javafx.scene.paint.Color.WHITE);
        text2.setLayoutX(596.0);
        text2.setLayoutY(331.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("SCORE");
        text2.setFont(new Font(18.0));

        text3.setFill(javafx.scene.paint.Color.WHITE);
        text3.setLayoutX(160.0);
        text3.setLayoutY(385.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("AAA");
        text3.setFont(new Font(18.0));

        text4.setFill(javafx.scene.paint.Color.WHITE);
        text4.setLayoutX(162.0);
        text4.setLayoutY(440.0);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("BBB");
        text4.setFont(new Font(18.0));

        text5.setFill(javafx.scene.paint.Color.WHITE);
        text5.setLayoutX(161.0);
        text5.setLayoutY(501.0);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("CCC");
        text5.setFont(new Font(18.0));

        text6.setFill(javafx.scene.paint.Color.WHITE);
        text6.setLayoutX(159.0);
        text6.setLayoutY(558.0);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("DDD");
        text6.setFont(new Font(18.0));

        text7.setFill(javafx.scene.paint.Color.WHITE);
        text7.setLayoutX(164.0);
        text7.setLayoutY(617.0);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("EEE");
        text7.setFont(new Font(18.0));

        text8.setFill(javafx.scene.paint.Color.WHITE);
        text8.setLayoutX(606.0);
        text8.setLayoutY(384.0);
        text8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text8.setStrokeWidth(0.0);
        text8.setText("AAS");
        text8.setFont(new Font(18.0));

        text9.setFill(javafx.scene.paint.Color.WHITE);
        text9.setLayoutX(607.0);
        text9.setLayoutY(439.0);
        text9.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text9.setStrokeWidth(0.0);
        text9.setText("BBS");
        text9.setFont(new Font(18.0));

        text10.setFill(javafx.scene.paint.Color.WHITE);
        text10.setLayoutX(607.0);
        text10.setLayoutY(500.0);
        text10.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text10.setStrokeWidth(0.0);
        text10.setText("CCS");
        text10.setFont(new Font(18.0));

        text11.setFill(javafx.scene.paint.Color.WHITE);
        text11.setLayoutX(608.0);
        text11.setLayoutY(558.0);
        text11.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text11.setStrokeWidth(0.0);
        text11.setText("DDS");
        text11.setFont(new Font(18.0));

        text12.setFill(javafx.scene.paint.Color.WHITE);
        text12.setLayoutX(609.0);
        text12.setLayoutY(615.0);
        text12.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text12.setStrokeWidth(0.0);
        text12.setText("EES");
        text12.setFont(new Font(18.0));

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(text3);
        getChildren().add(text4);
        getChildren().add(text5);
        getChildren().add(text6);
        getChildren().add(text7);
        getChildren().add(text8);
        getChildren().add(text9);
        getChildren().add(text10);
        getChildren().add(text11);
        getChildren().add(text12);

    }
}
