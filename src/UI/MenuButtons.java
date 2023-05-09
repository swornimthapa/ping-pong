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
    boolean mouseover,mousepressd,mousereleased;
    Gamestate state;
    BufferedImage[] images;
    private Rectangle bounds;
    public MenuButtons(int xposition, int yposition, int rowindex, Gamestate state) throws IOException {
            this.xposition=xposition;
            this.yposition=yposition;
            this.rowindex=rowindex;
            this.state=state;
            loadimages();
            initbounds();
    }

    private void initbounds() {
        bounds= new Rectangle(xposition,yposition,100,50);
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
    public void setMousepressd(boolean mousepressd){
       // mousereleased=false;
        this.mousepressd=mousepressd;
    }
    public void setReleased(boolean mousereleased){
       /// mousepressd=false;
        this.mousereleased=mousereleased;
    }
    public void setMousehover(boolean mouseover){
        this.mouseover=mouseover;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public boolean ismousedpressed(){
        return mousepressd;
    }
    public void resetBools(){
        mousepressd=false;
        mousereleased=false;
    }
    public void setGamestate(){
        Gamestate.state = state;

    }
    public Gamestate getGamestate(){
        return state;
    }


}
