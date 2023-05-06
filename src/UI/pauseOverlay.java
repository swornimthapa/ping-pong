package UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class pauseOverlay {
    BufferedImage pausebackground;
    int pausebx,pauseby,pausewidth,pauseheight;
    soundbottons soundbottons;
    soundbottons  sfxbuttons;
    urmbuttons unpause,replay,home;
    public pauseOverlay(){
        try {
            loadpausedbackground();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initpausebuttons();
    }

    private void initpausebuttons() {
        soundbottons = new soundbottons(500,150,40,40);
        sfxbuttons = new soundbottons(500,200,40,40);
        unpause = new urmbuttons(390,335,40,40,0);
        replay = new urmbuttons(440,335,40,40,1);
        home = new urmbuttons(490,335,40,40,2);
    }

    private void loadpausedbackground() throws IOException {
        this.pausebx=340;
        this.pauseby=50;
        this.pausewidth=250;
        this.pauseheight=350;
        pausebackground = loadsave.getSprites(loadsave.PAUSE_BACKGROUND);
    }

    public void update(){
        soundbottons.update();
        sfxbuttons.update();
        unpause.update();
        replay.update();
        home.update();
    }
    public void draw(Graphics2D g2d){
            g2d.drawImage(pausebackground,pausebx,pauseby,pausewidth,pauseheight,null);
            soundbottons.drawsoundimages(g2d);
            sfxbuttons.drawsoundimages(g2d);
            unpause.urmbuttonsdraw(g2d);
            replay.urmbuttonsdraw(g2d);
            home.urmbuttonsdraw(g2d);
    }


    public void mouseReleased(MouseEvent e) {
        if(isin(e,soundbottons)){
            if(soundbottons.isMousePressed()){
                soundbottons.setMuted(!soundbottons.isMuted());
            }

        } else if (isin(e,sfxbuttons)) {
            if(sfxbuttons.isMousePressed()){
                sfxbuttons.setMuted(!sfxbuttons.isMuted());
            }
        } else if (isin(e,unpause)) {
            if(unpause.isMousepressed()){
                unpause.setMousereleased(true);
            }

        } else if (isin(e,replay)) {
            if(replay.isMousepressed()){
                replay.setMousereleased(true);
            }

        } else if (isin(e,home)) {
            if(home.isMousereleased()){
                home.setMousereleased(true);
            }

        }
        soundbottons.resetBools();
        sfxbuttons.resetBools();
        unpause.restBools();
        replay.restBools();
        home.restBools();
    }


    public void mousePressed(MouseEvent e) {
        if(isin(e,soundbottons)){
            soundbottons.setMousePressed(true);
        }
        else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMousePressed(true);
        } else if (isin(e,replay)) {
            replay.setMousepressed(true);
        } else if (isin(e,unpause)) {
            unpause.setMousepressed(true);
        } else if (isin(e,home)) {
            home.setMousepressed(true);
        }
    }


    public void mouseMoved(MouseEvent e) {
        soundbottons.setMouseOver(false);
        sfxbuttons.setMouseOver(false);
        unpause.setMouseover(false);
        replay.setMouseover(false);
        home.setMouseover(false);
        if(isin(e,soundbottons)){
            soundbottons.setMouseOver(true);
        } else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMouseOver(true);
        } else if (isin(e,unpause)) {
            unpause.setMouseover(true);
        } else if (isin(e,replay)) {
            replay.setMouseover(true);
        } else if (isin(e,home)) {
            home.setMouseover(true);
        }

    }
    public boolean isin(MouseEvent e,pausebuttons p){
        return  (p.getBounds().contains(e.getX(),e.getY()));


    }

}
