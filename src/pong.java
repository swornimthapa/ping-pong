import java.awt.*;
public class pong {
    private  int circlex=50;
    private  int circley=50;

    keyhandler key;
    pong(keyhandler k){


        this.key=k;
    }

    public void update(){
        final int circlespeed=5;
        if(key.uppressed == true){
            circley=circley-circlespeed;
        } else if (key.downpressed) {
            circley=circley+circlespeed;
        }else if(key.leftpressed){
            circlex=circlex-circlespeed;
        } else if (key.rightpressed) {
            circlex=circlex+circlespeed;
        }
    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(circlex,circley,50,50);
    }


}
