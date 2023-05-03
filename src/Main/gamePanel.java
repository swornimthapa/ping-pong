package Main;

import entities.Paddle1;
import entities.Paddle2;
import entities.Pong;
import inputs.keyboardinputs;
import inputs.mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class gamePanel extends JComponent implements Runnable  {


    public Thread gamethread;
    private  final int fps=60;
//    private mouseinputs mouseInputs;
    Pong pong=new Pong();
    keyboardinputs keyinput = new keyboardinputs();
    Paddle1 paddle1;
    Paddle2 paddle2;



    public gamePanel(){
        //mouseinputs mouseInputs = new mouseinputs();

        this.setPreferredSize(new Dimension(900,500));
        this.setDoubleBuffered(true);//drawing will be done in off screen painting buffer---improves rendering
        this.setFocusable(true);
        addKeyListener(keyinput);
//        addMouseListener(mouseInputs);
//        addMouseMotionListener(mouseInputs);
        initplayer();
        gamethread= new Thread(this);
        gamethread.start();
    }

    private void initplayer() {
        paddle1= new Paddle1(0,Color.red,this,keyinput);
        paddle2 = new Paddle2(900 - 20,Color.BLUE, this, keyinput);
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
        paddle1.checkcollision();
        paddle2.checkcollision();
    }

    public void update(){
                pong.update();
                paddle1.update();
                paddle2.update();
    }
    @Override
    protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.addRenderingHints(rh);
                pong.draw(g2d);
                paddle1.draw(g2d);
                paddle2.draw(g2d);
                g2d.dispose();

    }

}
