package gamestates;

import Main.gamePanel;
import UI.AudioOptions;
import UI.gameOverOverlay;
import UI.pauseOverlay;
import entities.Paddle1;
import entities.Paddle2;
import entities.Pong;
import entities.Score;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class playing extends state implements statemethods{
    Pong pong=new Pong();

    Paddle1 paddle1;
    Paddle2 paddle2;
    pauseOverlay pausemenu;
    boolean pause=false;
    boolean gameover=false;
    Score score = new Score(pong);
    private gameOverOverlay gameovermenu;
    private AudioOptions audioOptions;
    public playing(gamePanel gamepanel, keyboardinputs key, inputs.mouseinputs mousekey) {
        super(gamepanel, key,mousekey);
        initplayer();
        intipausemenu();
    }

    private void intipausemenu() {
        this.audioOptions= new AudioOptions();
        pausemenu = new pauseOverlay(this);
        gameovermenu = new gameOverOverlay(this);
    }


    private void initplayer() {
        paddle1= new Paddle1(0, Color.red,gamepanel,keyinputs);
        paddle2 = new Paddle2(900 - 20,Color.BLUE, gamepanel,keyinputs);
    }

    @Override
    public void update() {
        gameover=score.checkgameover();
      //  System.out.println(gameover);
        if(!gameover) {


            if (!pause) {
                pong.update();
                paddle1.update();
                paddle2.update();

            } else{
                pausemenu.update();
            }
        }
        else {
            gameovermenu.update();
        }

    }


    @Override
    public void draw(Graphics2D g2d) {

            score.draw(g2d);
            pong.draw(g2d);
            paddle1.draw(g2d);
            paddle2.draw(g2d);

        if(!gameover){
            if(pause){
                pausemenu.draw(g2d);
            }
        }
       else{
            gameovermenu.drawGameoverlaybackground(g2d);
        }


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
        if(keycode==KeyEvent.VK_ESCAPE){
            pause=!pause;
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
            if(pause){
                pausemenu.mouseReleased(e);
            }
            if(gameover){
                gameovermenu.mouseReleased(e);
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(pause){
            pausemenu.mousePressed(e);
        }
        if(gameover){
            gameovermenu.mousePressed(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(pause){
            pausemenu.mouseMoved(e);
        }
        if (gameover) {
            gameovermenu.mouseMoved(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(pause){

            pausemenu.mouseDragged(e);
        }
    }

    public void unpausegame(){
        pause=false;
    }
    public AudioOptions getAudioOptions(){
        return audioOptions;
    }
    public  void resetall(){
        pong.reset();
        paddle1.reset();
        paddle2.reset();
        score.resetscore();
        gameover=false;
    }


}
