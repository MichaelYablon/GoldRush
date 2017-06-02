package interfaces;

import abstracts.NewAbstracts.AbstractGameMap;

import java.awt.*;

/**
 * Created by Miha on 19.02.2017.
 */
public interface DrawableMap extends MainMap{
    Component getMap();

    boolean drawMap();
}
