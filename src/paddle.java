import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class paddle implements  KeyListener{
    public int yvelocity=0;
   // public int initialYvelocity=0;
    public int ylocation=250-120;
    public int ylocation2=250-120;
    public int id;
    paddle(int id){
        this.id=id;
    }
    public void draw(Graphics2D g2d){
        if(id==1){
            g2d.setColor(Color.RED);
            g2d.fillRect(0,ylocation,20,120);
        }
        if(id==2){
            g2d.setColor(Color.blue);
            g2d.fillRect(900,ylocation2,20,120);
        }

    }
    public void setYvelocity(int yvelocity){
        ylocation=ylocation+yvelocity;
    }
    public void update(){
        setYvelocity(yvelocity);
       // yvelocity=0;
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        yvelocity=10;
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            yvelocity=-yvelocity;
            update();
        }
        if(keycode==KeyEvent.VK_S){
            yvelocity=yvelocity;
            update();
        }
    }


    public void keyReleased(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            yvelocity=0;
            update();
        }
        if(keycode==KeyEvent.VK_S){
            yvelocity=0;
            update();
        }
   }
}
