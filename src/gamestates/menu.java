package gamestates;

import Main.gamePanel;
import UI.MenuButtons;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class menu extends state implements statemethods{
    private MenuButtons[] menubuttos = new MenuButtons[3];

    public menu(gamePanel gamepanel, keyboardinputs key,mouseinputs mousekey) throws IOException {
        super(gamepanel, key,mousekey);
        loadbuttons();
    }

    private void loadbuttons() throws IOException {
        menubuttos[0]=new MenuButtons(900/2,100,0,Gamestate.PLAYING);
        menubuttos[1]=new MenuButtons(900/2,200,1,Gamestate.OPTIONS);
        menubuttos[2]=new MenuButtons(900/2,300,2,Gamestate.QUIT);
    }


    @Override
    public void update() {
        for(int i=0;i<3;i++){
            menubuttos[i].update();
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
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
//        for(int i=0;i<3;i++){
//
//            if(menubuttos[i].getBounds().contains(e.getX(),e.getY())){
//                menubuttos[i].setReleased(true);
//            }
//        }
//        resetbuttons();
    }

    private void resetbuttons() {
        for(int i=0;i<3;i++){
            menubuttos[i].resetBools();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i=0;i<3;i++){

            if(menubuttos[i].getBounds().contains(e.getX(),e.getY())){
                if(menubuttos[i].ismousedpressed()){
                    menubuttos[i].setReleased(true);
                }
            }
        }
        resetbuttons();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        for(int i=0;i<3;i++){
            if(menubuttos[i].getBounds().contains(e.getX(),e.getY())){
                menubuttos[i].setMousepressd(true);
            }
        }


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
