import java.awt.*;
import java.util.Random;

public class pong {
    private  int circlex=400;
    private  int circley=400;
    private  int  randomxdirection;
    private  int randomydirection;

//    keyhandler key;
//    pong(keyhandler k){
//
//
//        this.key=k;
//    }
    pong(){
        Random random=new Random();
         randomxdirection=random.nextInt(2);
         randomydirection=random.nextInt(2);
//        movexdirection(randomxdirection,randomydirection);

    }


//    public void movexdirection(int x,int y){
//        circlex=circlex-x;
//        circley=circley-y;
//    }
    public void update(){
       final int circlespeed=5;
//        if(key.uppressed == true){
//            circley=circley-circlespeed;
//        } else if (key.downpressed) {
//            circley=circley+circlespeed;
//        }else if(key.leftpressed){
//            circlex=circlex-circlespeed;
//        } else if (key.rightpressed) {
//            circlex=circlex+circlespeed;
//        }
        //randomxdirection=0 -> left and randomydirection=0->left
        if(randomydirection==0 && randomxdirection==0){
            circlex=circlex-1;
            circley=circley-1;
        }
        if(randomxdirection==1 && randomydirection==1){
            circlex=circlex+1;
            circley=circley+1;
        }
        if(randomxdirection==0 && randomydirection==1){
            circlex=circlex-1;
            circley=circley+1;
        }
        if(randomxdirection==1 && randomydirection==0){
            circlex=circlex+1;
            circley=circley-1;
        }




    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(circlex,circley,50,50);
    }


}
