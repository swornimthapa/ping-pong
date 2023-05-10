package Audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioPlayer {
    public static int menu=0;
    public static int option=1;
    public static int backgroundmusic=2;
//    public static int ballhit;
    public static int parry;
    public Clip[] music, effects;
    public Clip m;
    public int currentmusicid;
    public float volume =0.5f;
    public boolean songmute;
    public AudioPlayer() {
        loadmusic();
        loadEffect();
        playsong(menu);


    }
    public void loadmusic(){
        String[] names= {"menu","option","backgroundmusic"};
        music = new Clip[names.length];
        for(int i=0;i<music.length;i++){
            music[i]=getClip(names[i]);
        }
//        m=getClip("menu");
//        m.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void loadEffect(){
        String[] effectNames= {"parry"};
        effects = new Clip[effectNames.length];
        for(int i=0;i<effects.length;i++){
            effects[i]=getClip(effectNames[i]);
        }
    }
    private Clip getClip(String name){
        Clip clip;
        URL url = getClass().getResource("/audio/"+name+".wav");
        AudioInputStream audio;
        try {
            audio= AudioSystem.getAudioInputStream(url);
             clip = AudioSystem.getClip();
            clip.open(audio);
           // clip.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        return clip;
    }
    public void setVolume(float volume){
        this.volume=volume;
        updatemusicvolume();
    }
    public void stopSong(){
        if(music[currentmusicid].isActive()){
            music[currentmusicid].stop();
        }
    }
    public void playsong(int song){
        stopSong();
        currentmusicid=song;
       // updatemusicvolume();
        music[currentmusicid].setMicrosecondPosition(0);
        music[currentmusicid].start();
        music[currentmusicid].loop(Clip.LOOP_CONTINUOUSLY);


    }
    public void toggleSoundMusic(){
        this.songmute=!songmute;
        for(Clip c:music){
            BooleanControl booleanControl=(BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            booleanControl.setValue(songmute);
        }
    }
    private void updatemusicvolume(){
        FloatControl gaincontrol = (FloatControl) music[currentmusicid].getControl(FloatControl.Type.MASTER_GAIN);
        float range= gaincontrol.getMaximum()-gaincontrol.getMinimum();
        float gain = (range*volume)+ gaincontrol.getMinimum();
        gaincontrol.setValue(gain);
    }
    private void  updateEffectvolume(){

    }

    public void playEffect(int effect){
        effects[effect].setMicrosecondPosition(0);
        effects[effect].start();
    }

}
