package UI;

import gamestates.Gamestate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuButtons {
    int xposition;
    int yposition;
    int rowindex;
    int index;
    boolean mouseover,mousepressd;
    Gamestate state;
    BufferedImage[] images;
    public MenuButtons(int xposition, int yposition, int rowindex, Gamestate state) throws IOException {
            this.xposition=xposition;
            this.yposition=yposition;
            this.rowindex=rowindex;
            this.state=state;
            loadimages();
    }

    private void loadimages() throws IOException {
        images= new BufferedImage[3];
        BufferedImage temp= loadsave.getSprites(loadsave.MENU_BUTTONS);
        for(int i=0;i<images.length;i++){
            images[i]=temp.getSubimage(i*140,rowindex*56,140,56);
        }
    }
    public void draw(Graphics2D g){
        g.drawImage(images[index],xposition,yposition,100,50,null );
    }
    public void update(){
        index=0;
        if(mouseover){
            index=1;
        }
        if(mousepressd)
        {
            index=2;
        }
    }

}
