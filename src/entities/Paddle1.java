package entities;

import Main.gamePanel;
import inputs.keyboardinputs;

import java.awt.*;


public class Paddle1 extends Paddle{

    public Paddle1(int x,Color color, gamePanel panel, keyboardinputs key) {
        super(x,color, panel, key);
    }

    public void update(){
        yvelocity=10;
        if(key.upw){
            setYvelocity(-yvelocity);
        }
        if(key.downs){
            setYvelocity(yvelocity);
        }

    }


}
