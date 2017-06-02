package interfaces;

/**
 * Created by Miha on 17.02.2017.
 */
public interface GameMap {

    int getHeight();

    int getWidth();

    boolean loadMap(Object source);

    boolean saveMap(Object source);

//    boolean drawMap();

    int getTimeLimit();
}
