package entities;

import Main.gamePanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Pong extends Rectangle{
    public  int circlex=(900/2)-50;
    public   int circley=(500/2)-50;
    private int randomxdirection;
    private int randomydirection;
    public int xspeed=2;
    private int yspeed=2;
    public Shape oval;

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
        //collision with paddles

    }
    public void draw(Graphics2D g2d){
        oval=new Ellipse2D.Double(circlex,circley,50,50);
        g2d.setColor(Color.RED);
       // g2d.fillOval(circlex,circley,50,50);
        g2d.fill(oval);

    }
}
