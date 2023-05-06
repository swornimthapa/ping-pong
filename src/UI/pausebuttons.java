package UI;

import java.awt.*;

public class pausebuttons {
    int x, y, width, height;

    Rectangle bounds;
    public pausebuttons(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        createbounds();

    }


    public Rectangle getBounds(){
        return  bounds;
    }
    private void createbounds() {
        bounds = new Rectangle(x,y,width,height);
    }
}
