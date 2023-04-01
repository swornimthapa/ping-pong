import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setName("ping pong");

        gamePanel gamepanel=new gamePanel();
        frame.add(gamepanel);

//        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}