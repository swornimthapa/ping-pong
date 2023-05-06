package UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class soundbottons extends pausebuttons{
    BufferedImage[][] soundimages;
    boolean muted;
    int  rowindex, columnindex;
    boolean mouseOver , mousePressed , mouseReleased;
    public soundbottons(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadsoundimages();
    }

    private void loadsoundimages() {
        soundimages = new BufferedImage[2][3];
        try {
            BufferedImage temp = loadsave.getSprites(loadsave.sound_BUTTONS);
            for(int i=0;i<soundimages.length;i++){
                for(int j=0;j<soundimages[i].length;j++){
                    soundimages[i][j]=temp.getSubimage(j*42,i*42,42,42); //default size of one sound button
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void drawsoundimages(Graphics2D g2d){
        g2d.drawImage(soundimages[rowindex][columnindex],x,y,width,height,null);
    }
    public void update(){
        if(muted){
            rowindex=1;
        }
        else{
            rowindex=0;
        }
        columnindex=0;
        if(mouseOver){
            columnindex=1;
        }
        if(mousePressed){
            columnindex=2;
        }

    }
    public void resetBools(){
        mouseOver=false;
        mousePressed=false;
       // mouseReleased=false;
    }

//    public boolean isMouseOver() {
//        return mouseOver;
//    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver=mouseOver;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed=mousePressed;
    }

//    public boolean isMouseReleased() {
//        return mouseReleased;
//    }
    public void setMouseReleased(boolean mouseReleased){
        this.mouseReleased=mouseReleased;
    }

//    public void setRowindex(int rowindex){
//        this.rowindex = rowindex;
//    }
//    public int getRowindex(){
//        return rowindex;
//    }
//    public void setColumnindex(int columnindex){
//        this.columnindex= columnindex;
//    }
//    public int getColumnindex(){
//        return  columnindex;
//    }
    public void setMuted(boolean muted){
        this.muted = muted;
    }
    public boolean isMuted(){
        return  muted;
    }

}
