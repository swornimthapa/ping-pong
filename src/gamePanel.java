import javax.swing.*;
import java.awt.*;

public class gamePanel extends JComponent implements Runnable  {

    public Thread gamethread;
    private  int circlex=50;
    private  int circley=50;
    private  final int circlespeed=5;
    private  int fps=60;
    keyhandler key = new keyhandler();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);
        g2d.setColor(Color.RED);
        g2d.fillOval(circlex,circley,50,50);


    }

    public gamePanel(){
        this.addKeyListener(key);
        this.setFocusable(true);
        gamethread= new Thread(this);
        gamethread.start();

    }


    public void run() {
        double drawinterval=1000000000/fps;
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
        if(key.uppressed == true){
            circley=circley-circlespeed;
        } else if (key.downpressed) {
            circley=circley+circlespeed;
        }else if(key.leftpressed){
            circlex=circlex-circlespeed;
        } else if (key.rightpressed) {
            circlex=circlex+circlespeed;
        }
    }


}
