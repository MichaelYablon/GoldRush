package maps.loaders;

import objects.MapInfo;
import objects.SavedMapInfo;
import objects.User;

import java.util.ArrayList;

/**
 * Created by Miha on 24.02.2017.
 */
public interface MapLoader {
    boolean saveMap(SavedMapInfo mapInfo);

    boolean loadMap(MapInfo mapInfo);

    ArrayList<SavedMapInfo> getSavedMapList(User user);

    boolean deleteSavedMap(MapInfo mapInfo);
}
