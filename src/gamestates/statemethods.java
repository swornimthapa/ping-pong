package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface statemethods {
    public void update();
    public void draw(Graphics2D g2d);
    public void checkcollision();
    public void KeyPressed(KeyEvent e);
    public void KeyReleased(KeyEvent e);

}
