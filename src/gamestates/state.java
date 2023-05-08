package gamestates;

import Main.gamePanel;
import UI.MenuButtons;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import java.awt.event.MouseEvent;

public class state {
        protected keyboardinputs keyinputs;
        protected gamePanel gamepanel;
        protected mouseinputs mouseinputs;
        public state(gamePanel gamepanel,keyboardinputs key,mouseinputs mousekey){
            this.gamepanel=gamepanel;
            this.keyinputs=key;
            this.mouseinputs= mouseinputs;
        }
        public boolean ispressingbutton(MouseEvent e, MenuButtons buttons){
            return buttons.getBounds().contains(e.getX(),e.getY());
        }

}
