package UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class volumebutton extends  pausebuttons{
    boolean mouseover,mousepressed,mousereleased;
    int index;
    BufferedImage[] vbuttons;
    BufferedImage slider;
   // int volumewidth=100;
    private int minx,maxx;
    int buttonx;
    public volumebutton(int x, int y, int width, int height) {
        super(x+width/2, y, 30, height);
        this.buttonx=x+(width/2);
        this.x=x;
        this.width=width;
        this.minx=x+30/2;
        this.maxx=x+width-30/2;
        this.bounds.x -= 30/2;
        loadvolumebuttons();
    }
    private void loadvolumebuttons() {
        vbuttons = new BufferedImage[3];
        try {
            BufferedImage temp = loadsave.getSprites(loadsave.VOLUME_BUTTONS);
            for(int i=0;i<vbuttons.length;i++){
                vbuttons[i]=temp.getSubimage(i*28,0,28,44);
            }
            slider=temp.getSubimage(3*28,0,215,44);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(){
        index=0;
        if(mouseover){
            index=1;
        }
        if(mousepressed){
            index=2;
        }

    }
    public void slideslider(int x){
        if(x<minx){
            buttonx=minx;

        } else if (x>maxx) {
            buttonx=maxx;

        }else {
            buttonx=x;
            bounds.x=x;
        }
        bounds.x=buttonx-30/2;
    }
    public void volumebuttonsdraw(Graphics2D g2d){
        g2d.drawImage(slider,x,y,width,height,null);
        g2d.drawImage(vbuttons[index],buttonx-30/2,y,30,height,null);


    }
    public void setMousepressed(boolean mousepressed){
        this.mousepressed=mousepressed;
    }
    public boolean isMousepressed(){
        return mousepressed;
    }
    public void setMouseover(boolean mouseover){
        this.mouseover=mouseover;
    }
    public boolean isMouseover(){
        return mouseover;
    }
    public void setMousereleased(boolean mousereleased){
        this.mousereleased=mousereleased;
    }
    public boolean isMousereleased(){
        return  mousereleased;
    }
    public void restBools(){
        mouseover=false;
        mousepressed=false;
    }
}
