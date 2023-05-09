package gamestates;

import Audio.AudioPlayer;
import Main.gamePanel;
import UI.MenuButtons;
import UI.loadsave;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class menu extends state implements statemethods{
    private MenuButtons[] menubuttos = new MenuButtons[3];
    private BufferedImage backgroundimage;
    public menu(gamePanel gamepanel, keyboardinputs key,mouseinputs mousekey) throws IOException {
        super(gamepanel, key,mousekey);
        loadbuttons();
        loadbackgroundimage();
    }

    private void loadbackgroundimage() throws IOException {
        backgroundimage= loadsave.getSprites(loadsave.MENU_BACKGROUND);
    }

    private void loadbuttons() throws IOException {
        menubuttos[0]=new MenuButtons(390,150,0,Gamestate.PLAYING);
        menubuttos[1]=new MenuButtons(390,210,1,Gamestate.OPTIONS);
        menubuttos[2]=new MenuButtons(390,270,2,Gamestate.QUIT);
    }


    @Override
    public void update() {
        for(int i=0;i<3;i++){
            menubuttos[i].update();
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(backgroundimage,340,50,200,300,null);
      for(int i=0;i<3;i++){
            menubuttos[i].draw(g2d);
        }

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

    private void resetbuttons() {
        for(int i=0;i<3;i++){
            menubuttos[i].resetBools();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i=0;i<3;i++){

            if(ispressingbutton(e,menubuttos[i])){
                if(menubuttos[i].ismousedpressed()){
                    menubuttos[i].setReleased(true);
                    menubuttos[i].setGamestate();
                    gamepanel.getMenu().setGamestate(menubuttos[i].getGamestate());
                }
            }
        }
        resetbuttons();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        for(int i=0;i<3;i++){
            if(ispressingbutton(e,menubuttos[i])){
                menubuttos[i].setMousepressd(true);
            }
        }


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(int i=0;i<3;i++) {
           menubuttos[i].setMousehover(false);
        }
        for(int i=0;i<3;i++){
            if(ispressingbutton(e,menubuttos[i])){
                menubuttos[i].setMousehover(true);
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
