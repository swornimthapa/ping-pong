import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyhandler implements KeyListener {

    public boolean uppressed , downpressed , leftpressed, rightpressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP)
        {
            uppressed = true;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            downpressed = true;

        }
        else if(keyCode== KeyEvent.VK_LEFT){
            leftpressed =true;
        }
        else if(keyCode == KeyEvent.VK_RIGHT){
            rightpressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP)
        {
            uppressed = false;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            downpressed = false;

        }
        else if(keyCode== KeyEvent.VK_LEFT){
            leftpressed =false;
        }
        else if(keyCode == KeyEvent.VK_RIGHT){
            rightpressed = false;
        }
    }

}
