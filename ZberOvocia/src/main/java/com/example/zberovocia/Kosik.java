package com.example.zberovocia;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Kosik extends Canvas {


    Group root;
    Scene scene;
    GraphicsContext gc;
    public Kosik(int w, int h, Scene scene, Group root){
        super(w,h);
        this.scene = scene;
        this.root = root;
        gc = getGraphicsContext2D();
        setLayoutX(scene.getWidth()/2);
        setLayoutY(scene.getHeight()-h-20);
        vykresli();
        pohyb();
    }
    public void pohyb(){
        setFocusTraversable(true);
        setOnKeyPressed(event -> {

                if(event.getCode()== KeyCode.LEFT){
                    if(getLayoutX()-10<0);
                    else {
                        setLayoutX(getLayoutX()-20);
                        setLayoutY(scene.getHeight()-getHeight()-20);
                    }
                }

                if(event.getCode()==KeyCode.RIGHT) {
                    if(getLayoutX()+getWidth()+10>scene.getWidth());
                    else {
                        setLayoutX(getLayoutX() + 20);
                        setLayoutY(scene.getHeight()-getHeight()-20);
                    }
                }

        });
    }
    public void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeLine(1,getHeight(),1,0);
        gc.strokeLine(getWidth()/4,getHeight(),getWidth()/4,0);
        gc.strokeLine(getWidth()/4*2,getHeight(),getWidth()/4*2,0);
        gc.strokeLine(getWidth()/4*3,getHeight(),getWidth()/4*3,0);
        gc.strokeLine(getWidth()-1,getHeight(),getWidth()-1,0);
        gc.strokeLine(0,getHeight(),getWidth(),getHeight());
        gc.strokeLine(0,getHeight()/4*3,getWidth(),getHeight()/4*3);
        gc.strokeLine(0,getHeight()/4*2,getWidth(),getHeight()/4*2);
        gc.strokeLine(0,getHeight()/4,getWidth(),getHeight()/4);
    }
}
