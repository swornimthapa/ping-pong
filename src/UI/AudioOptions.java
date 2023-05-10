package UI;

import Audio.AudioPlayer;
import gamestates.Gamestate;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AudioOptions {
    soundbottons soundbottons;
    soundbottons  sfxbuttons;
    volumebutton volumebutton;


    public AudioOptions(){
        createsoundbuttons();
        createvolumebuttons();
    }
    private void createsoundbuttons() {
        soundbottons = new soundbottons(500,150,40,40);
        sfxbuttons = new soundbottons(500,200,40,40);
    }
    private void createvolumebuttons() {
        volumebutton= new volumebutton(365,290,200,40);
    }
    public void update(){
        soundbottons.update();
        sfxbuttons.update();
        volumebutton.update();

    }
    public void draw(Graphics2D g2d){
        soundbottons.drawsoundimages(g2d);
        sfxbuttons.drawsoundimages(g2d);
        volumebutton.volumebuttonsdraw(g2d);
    }
    public void mouseReleased(MouseEvent e) {
        if(isin(e,soundbottons)){
            if(soundbottons.isMousePressed()){
                soundbottons.setMuted(!soundbottons.isMuted());
                AudioPlayer.toggleSoundMusic();
            }

        } else if (isin(e,sfxbuttons)) {
            if(sfxbuttons.isMousePressed()){
                sfxbuttons.setMuted(!sfxbuttons.isMuted());
            }
        } else if (isin(e,volumebutton)) {
            if(volumebutton.isMousepressed()){
                volumebutton.setMousereleased(true);
            }
        }
        soundbottons.resetBools();
        sfxbuttons.resetBools();
        volumebutton.restBools();
    }


    public void mousePressed(MouseEvent e) {
        if(isin(e,soundbottons)){
            soundbottons.setMousePressed(true);
        }
        else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMousePressed(true);
        } else if (isin(e,volumebutton)) {
            volumebutton.setMousepressed(true);
        }
    }


    public void mouseMoved(MouseEvent e) {
        soundbottons.setMouseOver(false);
        sfxbuttons.setMouseOver(false);

        volumebutton.setMouseover(false);
        if(isin(e,soundbottons)){
            soundbottons.setMouseOver(true);
        } else if (isin(e,sfxbuttons)) {
            sfxbuttons.setMouseOver(true);
        }else if(isin(e,volumebutton)){
            volumebutton.setMouseover(true);
        }

    }
    public void mouseDragged(MouseEvent e){
        if(volumebutton.isMousepressed()){
            volumebutton.slideslider(e.getX());
        }
    }
    public boolean isin(MouseEvent e,pausebuttons p){
        return  (p.getBounds().contains(e.getX(),e.getY()));


    }

}
