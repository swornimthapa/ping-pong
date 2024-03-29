package UI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadsave {
    public static final String MENU_BUTTONS ="button_atlas.png";
    public static final String MENU_BACKGROUND ="menu_background.png";
    public static final String PAUSE_BACKGROUND ="pause_menu.png";
    public static final String sound_BUTTONS ="sound_button.png";
    public static final String URM_BUTTONS ="urm_buttons.png";
    public static final String VOLUME_BUTTONS ="volume_buttons.png";
    public static final String OPTION_BACKGROUND ="options_background.png";
    public static final String GAMEOVER_BACKGROUND = "death_screen.png";
    public static  BufferedImage getSprites(String filename) throws IOException {
        BufferedImage img=null;
        InputStream is =loadsave.class.getResourceAsStream("/"+filename);
        img= ImageIO.read(is);
        is.close();
        return img;


    }
}
