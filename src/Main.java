import javax.swing.*;
import java.awt.*;

public class Main {
    public static  int framewidth=900;
    public static  int frameheight=500;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setName("ping pong");
        frame.setSize(framewidth,frameheight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        gamePanel gamepanel=new gamePanel();

        frame.add(gamepanel);
    }
}