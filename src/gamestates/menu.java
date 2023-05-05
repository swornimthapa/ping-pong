package gamestates;

import Main.gamePanel;
import UI.MenuButtons;
import inputs.keyboardinputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class menu extends state implements statemethods{
    private MenuButtons[] menubuttos = new MenuButtons[3];

    public menu(gamePanel gamepanel, keyboardinputs key) throws IOException {
        super(gamepanel, key);
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
}
