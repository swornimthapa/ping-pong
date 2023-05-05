package gamestates;

import Main.gamePanel;
import inputs.keyboardinputs;
import inputs.mouseinputs;

public class state {
        protected keyboardinputs keyinputs;
        protected gamePanel gamepanel;
        protected mouseinputs mouseinputs;
        public state(gamePanel gamepanel,keyboardinputs key,mouseinputs mousekey){
            this.gamepanel=gamepanel;
            this.keyinputs=key;
            this.mouseinputs= mouseinputs;
        }
}
