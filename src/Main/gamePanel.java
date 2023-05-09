package Main;

import Audio.AudioPlayer;
import UI.AudioOptions;
import entities.Paddle1;
import entities.Paddle2;
import entities.Pong;
import gamestates.Gamestate;
import gamestates.gameOptions;
import inputs.keyboardinputs;
import gamestates.playing;
import gamestates.menu;
import inputs.mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;


public class gamePanel extends JComponent implements Runnable  {


    public Thread gamethread;
    private  final int fps=60;
   private mouseinputs mouseInputs = new mouseinputs(this);
//    Pong pong=new Pong();
    keyboardinputs keyinput = new keyboardinputs(this);
//    Paddle1 paddle1;
//    Paddle2 paddle2;
    playing playing;
    menu menu;
    gameOptions gameoptions;
    AudioPlayer audioPlayer;
    public gamePanel() throws IOException {
        //mouseinputs mouseInputs = new mouseinputs();

        this.setPreferredSize(new Dimension(900,500));
        this.setDoubleBuffered(true);//drawing will be done in off screen painting buffer---improves rendering
        this.setFocusable(true);
        addKeyListener(keyinput);
        addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);
        initplayer();
        gamethread= new Thread(this);
        gamethread.start();
    }

    private void initplayer() throws IOException {

//        paddle1= new Paddle1(0,Color.red,this,keyinput);
//        paddle2 = new Paddle2(900 - 20,Color.BLUE, this, keyinput);
            playing = new playing(this,keyinput,mouseInputs);
            menu = new menu(this,keyinput,mouseInputs);
            gameoptions = new gameOptions(this,keyinput,mouseInputs);
            audioPlayer= new AudioPlayer();
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
        switch (Gamestate.state){

            case PLAYING:
//                pong.checkcollision(paddle1,paddle2);
//                paddle1.checkcollision();
//                paddle2.checkcollision();
                playing.checkcollision();
                break;
            case MENU:

                break;
            case OPTIONS:
                break;
            default:
                break;
        }

    }

    public void update(){
        switch (Gamestate.state){

            case PLAYING:
//                pong.update();
//                paddle1.update();
//                paddle2.update();
                playing.update();
                break;
            case MENU:
                menu.update();
                break;
            case OPTIONS:
                gameoptions.update();
                break;
            case QUIT:
                System.exit(0);
                break;
            default:

                break;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);
        switch (Gamestate.state){

            case PLAYING:
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//                RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//                g2d.addRenderingHints(rh);
//                pong.draw(g2d);
//                paddle1.draw(g2d);
//                paddle2.draw(g2d);
//                g2d.dispose();
                playing.draw(g2d);
                break;
            case MENU:
               menu.draw(g2d);
                break;
            case OPTIONS:
                gameoptions.draw(g2d);
                break;
            default:
                break;
        }
    }
    public playing getPlaying(){
        return playing;
    }
    public  menu getMenu(){
        return menu;
    }
    public gameOptions getgameoptions(){
        return gameoptions;
    }
    public AudioPlayer getAudioPlayer(){
        return audioPlayer;
    }

}
