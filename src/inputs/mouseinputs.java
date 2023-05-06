package inputs;

import Main.gamePanel;
import gamestates.Gamestate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseinputs implements MouseListener , MouseMotionListener {

    gamePanel gamepanel;

    public mouseinputs(gamePanel gamepanel){
        this.gamepanel=gamepanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                gamepanel.getPlaying().mousePressed(e);
                break;
            case MENU:
                gamepanel.getMenu().mousePressed(e);
                break;
            case OPTIONS:
                gamepanel.getgameoptions().mousePressed(e);
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                 gamepanel.getPlaying().mouseReleased(e);
                break;
            case MENU:
                gamepanel.getMenu().mouseReleased(e);
                break;
            case OPTIONS:
                gamepanel.getgameoptions().mouseReleased(e);
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                 gamepanel.getPlaying().mouseDragged(e);
                break;
            case MENU:
                //gamepanel.getMenu().mouseMoved(e);
                break;
            case OPTIONS:
                gamepanel.getgameoptions().mouseDragged(e);
            default:
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state){
            case PLAYING:
                 gamepanel.getPlaying().mouseMoved(e);
                break;
            case MENU:
                gamepanel.getMenu().mouseMoved(e);
                break;
            case OPTIONS:
                gamepanel.getgameoptions().mouseMoved(e);
            default:
                break;
        }
    }
}
