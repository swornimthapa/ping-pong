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
    public pauseOverlay(){
        try {
            loadpausedbackground();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initsoundbuttons();
    }

    private void initsoundbuttons() {
        soundbottons = new soundbottons(500,150,40,40);
        sfxbuttons = new soundbottons(500,200,40,40);
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
    }
    public void draw(Graphics2D g2d){
            g2d.drawImage(pausebackground,pausebx,pauseby,pausewidth,pauseheight,null);
            soundbottons.drawsoundimages(g2d);
            sfxbuttons.drawsoundimages(g2d);
    }


    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        if(isin(e,soundbottons)){
            if(soundbottons.isMousePressed()){
                soundbottons.setMuted(!soundbottons.isMuted());
            }

        } else if (isin(e,sfxbuttons)) {
            if(sfxbuttons.isMousePressed()){
                sfxbuttons.setMuted(!sfxbuttons.isMuted());
            }


        }
        soundbottons.resetBools();
        sfxbuttons.resetBools();
    }


    public void mousePressed(MouseEvent e) {
        System.out.println("mousepressed");
        if(isin(e,soundbottons)){
            soundbottons.setMousePressed(true);
        }
        else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMousePressed(true);
        }
    }


    public void mouseMoved(MouseEvent e) {
        soundbottons.setMouseOver(false);
        sfxbuttons.setMouseOver(false);
        if(isin(e,soundbottons)){
            soundbottons.setMouseOver(true);
        } else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMouseOver(true);
        }

    }
    public boolean isin(MouseEvent e,pausebuttons p){
        return  (p.getBounds().contains(e.getX(),e.getY()));


    }

}
