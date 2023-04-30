import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gamePanel extends JComponent implements Runnable  {


   public Thread gamethread;
    private  final int fps=60;
//    keyhandler key = new keyhandler();
    pong pong=new pong();
    paddle paddle1=new paddle(1);
    paddle paddle2= new paddle(2);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);
        pong.draw(g2d);
        paddle1.draw(g2d);
        paddle2.draw(g2d);
    }

    public gamePanel(){
        this.setPreferredSize(new Dimension(900,500));
        this.setDoubleBuffered(true);//drawing will be done in off screen painting buffer---improves rendering
        this.setFocusable(true);
        this.addKeyListener(paddle1);

        gamethread= new Thread(this);
        gamethread.start();
    }


    public void run() {
        double drawinterval=(double) 1000000000/fps;
        double delta=0;
        long lasttime=System.nanoTime();
        long currenttime;
        while(true){
            currenttime=System.nanoTime();
            delta=delta+((currenttime-lasttime)/drawinterval);
            lasttime = currenttime;
            if(delta>=1){
                update();

                checkcollision();

                repaint();
                delta--;
            }

        }

    }
    public void checkcollision(){
        pong.checkcollision();
    }

    public void update(){
        pong.update();
        paddle1.update();
    }
}
