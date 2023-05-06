package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface statemethods {
    public void update();
    public void draw(Graphics2D g2d);
    public void checkcollision();
    public void KeyPressed(KeyEvent e);
    public void KeyReleased(KeyEvent e);
    public void mouseClicked(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseMoved(MouseEvent e);
    public void mouseDragged(MouseEvent e);

}
