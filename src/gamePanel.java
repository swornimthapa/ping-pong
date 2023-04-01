import javax.swing.*;
import java.awt.*;

public class gamePanel extends JComponent implements Runnable  {

    public Thread gamethread;
    private  final int fps=60;
    keyhandler key = new keyhandler();
    pong pong;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);
        pong.draw(g2d);
    }

    public gamePanel(){
        this.addKeyListener(key);
        this.setFocusable(true);
        pong = new pong(key);
        gamethread= new Thread(this);
        gamethread.start();

    }


    public void run() {
        double drawinterval=(double) 1000000000/fps;
        double delta=0;
        long lasttime=System.nanoTime();
        long currenttime;
        while(gamethread!=null){
            currenttime=System.nanoTime();
            delta=delta+((currenttime-lasttime)/drawinterval);
            lasttime = currenttime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }

        }

    }
    public void update(){

        pong.update();

    }


}
