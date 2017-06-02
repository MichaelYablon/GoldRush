package abstracts;

import sounds.SoundObject;
import sounds.WavPlayer;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 24.02.2017.
 */
public abstract class AbstractSoundObject extends AbstractMovingObject implements SoundObject {

    private transient Clip dieClip;

    public Clip getDieClip() {
        if (dieClip==null){
            setDieClip();
        }
        return dieClip;
    }


    protected Clip openClip(String soundName) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/" + soundName));
            clip.open(ais);
            return clip;
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AbstractSoundObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AbstractSoundObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AbstractSoundObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private void setDieClip() {
        dieClip = openClip("/sounds/die.wav");
    }


}
