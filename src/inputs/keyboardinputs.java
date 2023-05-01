package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboardinputs implements KeyListener {

    public boolean up,down;
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            up=true;
        }
        if(keycode==KeyEvent.VK_S){
            down=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            up=false;
        }
        if(keycode==KeyEvent.VK_S){
            down=false;
        }
    }
}
