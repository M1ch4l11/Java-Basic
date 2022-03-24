package com.example.zberovocia;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    public static int pocCycle;
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 600);
        scene.setFill(Color.SKYBLUE);
        Button btnStart = new Button("Start");
        btnStart.setPrefSize(150,100);
        btnStart.setLayoutX(scene.getWidth()/3);
        btnStart.setLayoutY(scene.getHeight()/3);
        btnStart.setStyle("-fx-background-color: #5AA24C;-fx-font-family: 'Arial Black';");
        btnStart.setOnAction(event -> {
            Label lb = new Label("0");
            lb.setStyle("-fx-font-family: 'Arial Black';-fx-font-size: 50;");
            lb.setLayoutX(scene.getWidth()-100);
            lb.setLayoutY(20);
            Timeline tm = new Timeline(new KeyFrame(Duration.seconds(2),e -> {
                Ovocie fruit = new Ovocie(20,20,scene,root,lb);
                root.getChildren().add(fruit);
            }));
            Kosik kosik = new Kosik(80,42,scene,root);
            root.getChildren().remove(btnStart);
            root.getChildren().addAll(kosik,lb);
            tm.setCycleCount(60);
            tm.play();
        });
        root.getChildren().add(btnStart);
        stage.setTitle("Zber Ovocia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}