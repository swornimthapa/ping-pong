package entities;

import java.awt.*;
import java.util.Random;

public class Pong {
    private  int circlex=(900/2)-50;
    private  int circley=(500/2)-50;
    private int randomxdirection;
    private int randomydirection;

    public int xspeed=2;
    private int yspeed=2;

    public Pong(){
        Random random=new Random();
        randomxdirection=random.nextInt(2);
        if(randomxdirection==0){
            xspeed=-xspeed;
            setxvelocity(xspeed);
        }
        if(randomxdirection==1){
            setxvelocity(xspeed);
        }

        randomydirection=random.nextInt(2);
        if(randomydirection==0){
            yspeed=-yspeed;
            setyvelocity(yspeed);
        }
        if(randomydirection==1){
            setyvelocity(yspeed);
        }

    }
    public  void setxvelocity(int xspeed){
        circlex=circlex+xspeed;
    }
    public void setyvelocity(int yspeed){
        circley=circley+yspeed;

    }
    public void update(){
        setxvelocity(xspeed);
        setyvelocity(yspeed);

    }
    public void checkcollision(){
        if(circlex<=0){
            xspeed=-xspeed;
        }
        if(circley<=0){
            yspeed=-yspeed;
        }
        if(circlex==900-50){

            xspeed=-xspeed;
        }
        if(circley==500-50){
            yspeed=-yspeed;
        }

    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(circlex,circley,50,50);
    }
}