package gamestates;

import Audio.AudioPlayer;
import Main.gamePanel;
import UI.MenuButtons;
import inputs.keyboardinputs;
import inputs.mouseinputs;
import org.ietf.jgss.GSSManager;

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
        public void setGamestate(Gamestate state){
                switch (state){
                    case MENU:
                        gamepanel.getAudioPlayer().playsong(AudioPlayer.menu);
                        break;
                    case PLAYING:
                        gamepanel.getAudioPlayer().playsong(AudioPlayer.backgroundmusic);
                        break;
                    case OPTIONS:
                        gamepanel.getAudioPlayer().playsong(AudioPlayer.option);
                        break;
                }
                Gamestate.state=state;
        }
}
