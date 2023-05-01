package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboardinputs implements KeyListener {

    public boolean upw,downs,uparrow,downarrow;
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            upw=true;
        }
        if(keycode==KeyEvent.VK_S){
            downs=true;
        }
        if(keycode==KeyEvent.VK_UP){
            uparrow=true;
        }
        if(keycode==KeyEvent.VK_DOWN){
            downarrow=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            upw=false;
        }
        if(keycode==KeyEvent.VK_S){
            downs=false;
        }
        if(keycode==KeyEvent.VK_UP){
            uparrow=false;
        }
        if(keycode==KeyEvent.VK_DOWN){
            downarrow=false;
        }
    }
}
