package gamestates;

import Main.gamePanel;
import inputs.keyboardinputs;

public class state {
        protected keyboardinputs keyinputs;
        protected gamePanel gamepanel;
        public state(gamePanel gamepanel,keyboardinputs key){
            this.gamepanel=gamepanel;
            this.keyinputs=key;
        }
}
