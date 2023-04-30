import javax.swing.*;
import java.awt.*;

public class Main {
    public static  int framewidth=900;
    public static  int frameheight=500;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setName("ping pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        gamePanel gamepanel=new gamePanel();
        frame.add(gamepanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}