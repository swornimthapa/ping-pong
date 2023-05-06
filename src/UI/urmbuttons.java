package UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class urmbuttons extends pausebuttons{
    BufferedImage[] urmbuttons;
    private int rowIndex;
    int index;
    boolean mouseover,mousepressed,mousereleased;

    public urmbuttons(int x, int y, int width, int height,int rowIndex) {
        super(x, y, width, height);
        this.rowIndex=rowIndex;
        loadurmbuttons();
    }

    private void loadurmbuttons() {
        urmbuttons = new BufferedImage[3];
        try {
            BufferedImage temp= loadsave.getSprites(loadsave.URM_BUTTONS);
            for(int i=0;i<urmbuttons.length;i++){
                    urmbuttons[i]=temp.getSubimage(i*56,rowIndex*56,56,56);

            }
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
    public void urmbuttonsdraw(Graphics2D g2d){
        g2d.drawImage(urmbuttons[index],x,y,width,height,null);

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
