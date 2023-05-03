package entities;

import Main.gamePanel;
import inputs.keyboardinputs;

import java.awt.*;

public abstract class  Paddle extends Rectangle{
    protected int yvelocity=0;
//    public int ylocation=250-120;
//    public int xlocation;
    public Shape rectangle;
    gamePanel panel;
    keyboardinputs key;

    protected Color colour;
    public Paddle(int x,Color colour,gamePanel panel,keyboardinputs key){
//        this.xlocation=x;
        this.y=250-120;
        this.x=x;
        this.width=20;
        this.height=120;
        this.panel=panel;
        this.key=key;
        this.colour=colour;

    }
    public void draw(Graphics2D g2d){
        rectangle = new Rectangle(this.x,this.y,this.width,this.height);
        g2d.setColor(colour);
       // g2d.fillRect(xlocation,ylocation,20,120);
        g2d.fill(rectangle);
    }
    protected void setYvelocity(int yvelocity){
        this.y=this.y+yvelocity;
    }
    public void checkcollision(){
        if(this.y<=0){
            this.y=0;
        }
        if(this.y+120>=500){
            this.y=500-120;
        }
        setYvelocity(0);
    }
}
