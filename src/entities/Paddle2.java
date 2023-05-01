package entities;

import Main.gamePanel;
import inputs.keyboardinputs;

import java.awt.*;

public class Paddle2 extends  Paddle{
    public Paddle2(int x,Color color,gamePanel panel, keyboardinputs key) {
        super(x, color,panel, key);
    }
    public void update(){
        yvelocity=10;
        if(key.uparrow){
            setYvelocity(-yvelocity);
        }
        if(key.downarrow){
            setYvelocity(yvelocity);
        }

    }
}

