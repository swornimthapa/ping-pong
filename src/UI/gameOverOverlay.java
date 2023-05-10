package UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import gamestates.Gamestate;
import gamestates.playing;

public class gameOverOverlay {
    BufferedImage gameoverbackground;
    int overbx,overby,overbwidth,overbheight;
    urmbuttons home,replay;
    playing playing;
    public gameOverOverlay(playing playing){
        this.playing=playing;
        loadgameoverbackground();
        loadurmbuttons();
    }

    private void loadurmbuttons() {
        replay= new urmbuttons(470,200,40,40,0);
        home= new urmbuttons(380,200,40,40,2);
    }

    private void loadgameoverbackground() {
        try {
            gameoverbackground=loadsave.getSprites(loadsave.GAMEOVER_BACKGROUND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
        home.update();
        replay.update();

    }
    public void drawGameoverlaybackground(Graphics2D g2d){
        g2d.drawImage(gameoverbackground,340,55,220,300,null);
        home.urmbuttonsdraw(g2d);
        replay.urmbuttonsdraw(g2d);
    }
    public void mouseMoved(MouseEvent e){
        home.setMouseover(false);
        replay.setMouseover(false);
        if(isin(e,home)){
            home.setMouseover(true);
        } else if (isin(e,replay)) {
            replay.setMouseover(true);
        }

    }
    public void mouseReleased(MouseEvent e){
        if(isin(e,home)){
            if(home.isMousepressed()){
                home.setMousereleased(true);
                playing.resetall();
                playing.setGamestate(Gamestate.MENU);
            }
        } else if (isin(e,replay)) {
            if(replay.isMousepressed()){
                replay.setMousereleased(true);
                playing.resetall();

            }

        }
        home.restBools();
        replay.restBools();
    }
    public void mousePressed(MouseEvent e){
        if(isin(e,home)){
            home.setMousepressed(true);
        } else if (isin(e,replay)) {
            replay.setMousepressed(true);
        }

    }
    public boolean  isin(MouseEvent e,urmbuttons b){
        return (b.getBounds().contains(e.getX(),e.getY()));
    }


}
