package com.example.zberovocia;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static com.example.zberovocia.HelloApplication.pocCycle;

public class Ovocie extends Canvas {
    Scene scene;
    Group root;
    Timeline time;
    int speed;
    Color farba;
    GraphicsContext gc;
    Label lb;
    public static int  poc = 0;
    public Ovocie(int w, int h, Scene scene, Group root, Label lb){
        super(w,h);
        this.lb = lb;
        int pom;
        while (true){
            pom = (int)(Math.random()*scene.getWidth()-getWidth());
            if(pom<0)continue;
            else break;
        }
        setLayoutX(pom);
        setLayoutY(0);
        gc = getGraphicsContext2D();
        this.scene = scene;
        farba = Color.rgb(getNumber(),getNumber(),getNumber());
        this.root = root;
        while (true){
            speed = ( -40 + (int) (Math.random()*30.0))*-1;
            if(speed<5)continue;
            else break;
        }
        vykresli();
        pohyb();
    }
    public void pohyb(){
        time = new Timeline(new KeyFrame(Duration.millis(speed),event -> {
            int pomX = 0;
            int pomY = 0;
            double wK = 0.0;
            for (int i = 0; i < root.getChildren().size(); i++) {
                Node item = root.getChildren().get(i);
                if(item instanceof Kosik){
                    pomX = (int) item.getLayoutX();
                    pomY = (int) item.getLayoutY();
                    wK = ((Kosik) item).getWidth();
                }
            }
            double a1 =   pomX - getLayoutX();
            double a2 =   pomY - getLayoutY() ;
            if((Math.abs(a1)<wK)&& Math.abs(a2)<getHeight()){
                lb.setText(++poc + "");
                root.getChildren().remove(this);
                pocCycle++;
                if(pocCycle==60){
                    lb.setLayoutY(scene.getWidth()/3);
                    lb.setText("Your \n"+"Score: " + lb.getText());
                    lb.setLayoutX(scene.getWidth()/3-lb.getWidth());
                }
                time.stop();
            }
            if(getLayoutY()<scene.getHeight()){
                setLayoutY(getLayoutY()+3);
                vykresli();
            }else {
                root.getChildren().remove(this);
                pocCycle++;
                if(pocCycle==60){
                    lb.setLayoutY(scene.getWidth()/3);
                    lb.setText( "Your \n"+ "Score: "  + lb.getText());
                    lb.setLayoutX(scene.getWidth()/3-lb.getWidth());
                }
                time.stop();
            }
        }));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
    public int getNumber(){
        return (-200+(int)(Math.random()*100.0))*-1;
    }
    public void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(farba);
        gc.fillOval(0,0,getWidth(),getHeight());

    }
}
