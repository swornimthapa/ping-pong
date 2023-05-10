package entities;

import Main.gamePanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Pong extends Rectangle{
//    public  int circlex=(900/2)-50;
//    public   int circley=(500/2)-50;
    private int randomxdirection;
    private int randomydirection;
    public int xspeed=2;
    private int yspeed=2;
    public Shape oval;

    public Pong(){
        this.x=(900/2)-50;
        this.y=(500/2)-50;
        this.width=50;
        this.height=50;

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
        this.x= this.x+xspeed;
    }
    public void setyvelocity(int yspeed){
        this.y= this.y+yspeed;

    }
    public void update(){
        setxvelocity(xspeed);
        setyvelocity(yspeed);

    }
    public void checkcollision(Paddle1 paddle1,Paddle2 paddle2){

//        if( this.x<=0){
//            xspeed=-xspeed;
//        }
        if( this.y<=0){
            yspeed=-yspeed;
        }
        if( this.x==900-50){
           // Score.player1+=1;
            Score.updatescore(this.x);
            reset();
        }
        if(this.x<0){
           // Score.player2+=1;
            Score.updatescore(this.x);
            reset();
        }
        if( this.y==500-50){
            yspeed=-yspeed;
        }
        //collision with paddles
        if(this.intersects(paddle1)){
            System.out.println("paddle1 hit");
            xspeed=-xspeed;
        }
        if(this.intersects(paddle2)){
            System.out.println("paddle 2 hit");
            xspeed=-xspeed;
        }

    }
    public void draw(Graphics2D g2d){
        oval=new Ellipse2D.Double(this.x,this.y,this.width,this.height);
        g2d.setColor(Color.RED);
       // g2d.fillOval(circlex,circley,50,50);
        g2d.fill(oval);

    }

    public void reset(){
        this.x=(900/2)-50;
        this.y=(500/2)-50;
        xspeed*=-1;
    }

}
