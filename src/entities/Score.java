package entities;

import java.awt.*;

public class Score extends Rectangle {
    static int G_width;
    static int G_height;
    static int player1;
    static int player2;

    Paddle1 paddle1;
    Paddle2 paddle2;
    Pong pong = new Pong();

    public void reset(){
        G_width=900/2;
        G_height=500/2;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawLine(900/2,0,900/2,500);

        g.drawString(player1 / 10 +String.valueOf(player1%10),(900/2)-85,50);
        g.drawString(player2 / 10 +String.valueOf(player2%10),(900/2)+20,50);
    }


}
