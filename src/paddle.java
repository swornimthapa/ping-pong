import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class paddle {
//    boolean wpressed,spressed;

    public int yvelocity=10;
    public int ylocation=250-120;
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillRect(0,ylocation,20,120);
    }
    public void setYvelocity(int yvelocity){
        ylocation=ylocation+yvelocity;
    }
    public void update(){

        setYvelocity(yvelocity);
        yvelocity=0;
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        yvelocity=10;
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            yvelocity=-yvelocity;
            update();
//            wpressed=true;
        }
        if(keycode==KeyEvent.VK_S){
            yvelocity=yvelocity;
            update();
//            spressed=true;
        }
    }


    public void keyReleased(KeyEvent e) {
//        int keycode=e.getKeyCode();
//        if(keycode==KeyEvent.VK_W){
//            wpressed=false;
//        }
//        if(keycode==KeyEvent.VK_S){
//            spressed=false;
//        }
//
   }
}
