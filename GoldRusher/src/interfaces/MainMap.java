package interfaces;

import maps.goldMan.*;
import objects.MapInfo;

/**
 * Created by Miha on 24.02.2017.
 */
public interface MainMap {
    MapInfo getMapInfo();

    maps.goldMan.GameCollection getGameCollection();// все карты должн хранить коллекцию объектов
}
