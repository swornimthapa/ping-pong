package entities;

import Main.gamePanel;
import inputs.keyboardinputs;

import java.awt.*;


public class Paddle {
    public int yvelocity=0;

    public int ylocation=250-120;
    public int ylocation2=250-120;
    public int id;
    keyboardinputs key;
    gamePanel panel;

    public Paddle(int id, gamePanel panel, keyboardinputs key){
        this.id=id;
        this.panel=panel;
        this.key=key;


    }
    public void draw(Graphics2D g2d){
        if(id==1){
            g2d.setColor(Color.RED);
            g2d.fillRect(0,ylocation,20,120);
        }
        if(id==2){
            g2d.setColor(Color.blue);
            g2d.fillRect(900-20,ylocation2,20,120);
        }

    }
    public void setYvelocity(int yvelocity){
        ylocation=ylocation+yvelocity;
        System.out.println(ylocation);
    }
    public void update(){
        yvelocity=10;
        if(key.up){
            setYvelocity(-yvelocity);
        }
        if(key.down){
            setYvelocity(yvelocity);
        }

    }
    public void checkcollision(){
        if(ylocation<=0){
            ylocation=0;
        }
        if(ylocation+120>=500){
            ylocation=500-120;
        }
        setYvelocity(0);
    }
}
