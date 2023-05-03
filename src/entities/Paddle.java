package entities;

import Main.gamePanel;
import inputs.keyboardinputs;

import java.awt.*;

public abstract class  Paddle extends Rectangle{
    protected int yvelocity=0;
    public int ylocation=250-120;
    public int xlocation;
    public Shape rectangle;
    gamePanel panel;
    keyboardinputs key;

    protected Color colour;
    public Paddle(int x,Color colour,gamePanel panel,keyboardinputs key){
        this.xlocation=x;
        this.panel=panel;
        this.key=key;
        this.colour=colour;

    }
    public void draw(Graphics2D g2d){
        rectangle = new Rectangle(xlocation,ylocation,20,120);
        g2d.setColor(colour);
       // g2d.fillRect(xlocation,ylocation,20,120);
        g2d.fill(rectangle);
    }
    protected void setYvelocity(int yvelocity){
        ylocation=ylocation+yvelocity;
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
