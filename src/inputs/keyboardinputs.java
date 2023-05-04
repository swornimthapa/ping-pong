package inputs;

import Main.gamePanel;
import gamestates.Gamestate;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboardinputs implements KeyListener {

    public boolean upw,downs,uparrow,downarrow;
    private gamePanel gamepanel;
    public keyboardinputs(gamePanel gamepanel){
        this.gamepanel=gamepanel;
    }
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                gamepanel.getPlaying().KeyPressed(e);
                break;
            case MENU:
                gamepanel.getMenu().KeyPressed(e);
                break;
            default:
                break;
        }
//        int keycode=e.getKeyCode();
//        if(keycode==KeyEvent.VK_W){
//            upw=true;
//        }
//        if(keycode==KeyEvent.VK_S){
//            downs=true;
//        }
//        if(keycode==KeyEvent.VK_UP){
//            uparrow=true;
//        }
//        if(keycode==KeyEvent.VK_DOWN){
//            downarrow=true;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                gamepanel.getPlaying().KeyReleased(e);
                break;
            case MENU:
                gamepanel.getMenu().KeyReleased(e);
                break;
            default:
                break;
        }
//        int keycode=e.getKeyCode();
//        if(keycode==KeyEvent.VK_W){
//            upw=false;
//        }
//        if(keycode==KeyEvent.VK_S){
//            downs=false;
//        }
//        if(keycode==KeyEvent.VK_UP){
//            uparrow=false;
//        }
//        if(keycode==KeyEvent.VK_DOWN){
//            downarrow=false;
//        }
    }
}
