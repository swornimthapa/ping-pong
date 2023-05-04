package gamestates;

import Main.gamePanel;
import entities.Paddle1;
import entities.Paddle2;
import entities.Pong;
import inputs.keyboardinputs;

import java.awt.*;
import java.awt.event.KeyEvent;

public class playing extends state implements statemethods{
    Pong pong=new Pong();

    Paddle1 paddle1;
    Paddle2 paddle2;

    public playing(gamePanel gamepanel, keyboardinputs key) {
        super(gamepanel, key);
        initplayer();
    }


    private void initplayer() {
        paddle1= new Paddle1(0, Color.red,gamepanel,keyinputs);
        paddle2 = new Paddle2(900 - 20,Color.BLUE, gamepanel,keyinputs);
    }

    @Override
    public void update() {
        pong.update();
        paddle1.update();
         paddle2.update();
    }

    @Override
    public void draw(Graphics2D g2d) {
        pong.draw(g2d);
        paddle1.draw(g2d);
        paddle2.draw(g2d);
        g2d.dispose();
    }

    @Override
    public void checkcollision() {
        pong.checkcollision(paddle1,paddle2);
        paddle1.checkcollision();
        paddle2.checkcollision();
    }

    @Override
    public void KeyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            keyinputs.upw=true;
        }
        if(keycode==KeyEvent.VK_S){
            keyinputs.downs=true;
        }
        if(keycode==KeyEvent.VK_UP){
            keyinputs.uparrow=true;
        }
        if(keycode==KeyEvent.VK_DOWN){
            keyinputs.downarrow=true;
        }
    }

    @Override
    public void KeyReleased(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            keyinputs.upw=false;
        }
        if(keycode==KeyEvent.VK_S){
            keyinputs.downs=false;
        }
        if(keycode==KeyEvent.VK_UP){
            keyinputs. uparrow=false;
        }
        if(keycode==KeyEvent.VK_DOWN){
            keyinputs. downarrow=false;
        }
    }
}
