package gamestates;

import Main.gamePanel;
import UI.AudioOptions;
import UI.loadsave;
import UI.pausebuttons;
import UI.urmbuttons;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class gameOptions extends state implements statemethods{
    private AudioOptions audioOptions;
    BufferedImage optionbackgroundimage;
    urmbuttons menu;
    public gameOptions(gamePanel gamepanel, keyboardinputs key, inputs.mouseinputs mousekey) {
        super(gamepanel, key, mousekey);
        loadbackgroundimages();
        loadimages();
        audioOptions=gamepanel.getPlaying().getAudioOptions();
    }

    private void loadimages() {
        menu = new urmbuttons(450,340,40,40,2);
    }

    private void loadbackgroundimages() {
        try {
            optionbackgroundimage = loadsave.getSprites(loadsave.OPTION_BACKGROUND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update() {
        menu.update();
        audioOptions.update();
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(optionbackgroundimage,340,60,250,350,null);
        menu.urmbuttonsdraw(g2d);
        audioOptions.draw(g2d);
    }





    @Override
    public void mouseReleased(MouseEvent e) {
        if(isin(e,menu)){
            if(menu.isMousepressed()){
                //Gamestate.state=Gamestate.MENU;
                this.setGamestate(Gamestate.MENU);
            }
        }else{
            audioOptions.mouseReleased(e);
        }
        menu.restBools();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(isin(e,menu)){
            menu.setMousepressed(true);
        }
        else{
            audioOptions.mousePressed(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        menu.setMouseover(false);
        if(isin(e,menu)){
            menu.setMouseover(true);

        }else {
            audioOptions.mouseMoved(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        audioOptions.mouseDragged(e);
    }

    public boolean isin(MouseEvent e, pausebuttons p){
        return  (p.getBounds().contains(e.getX(),e.getY()));


    }

    @Override
    public void checkcollision() {

    }

    @Override
    public void KeyPressed(KeyEvent e) {

    }

    @Override
    public void KeyReleased(KeyEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
