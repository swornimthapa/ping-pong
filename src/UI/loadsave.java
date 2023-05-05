package UI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadsave {
    public static final String MENU_BUTTONS ="button_atlas.png";
    public static final String MENU_BACKGROUND ="menu_background.png";
    public static  BufferedImage getSprites(String filename) throws IOException {
        BufferedImage img=null;
        InputStream is =loadsave.class.getResourceAsStream("/"+filename);
        img= ImageIO.read(is);
        is.close();
        return img;


    }
}
