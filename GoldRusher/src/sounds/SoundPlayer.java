package sounds;

/**
 * Created by Miha on 23.02.2017.
 */
public interface SoundPlayer {

    void startBackgroundMusic(String soundName);

    void stopBackgroundMusic();

    void playSound(String name, final boolean loop);
}
