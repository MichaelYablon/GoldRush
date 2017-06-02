package creators;

import abstracts.AbstractGameMap;
import abstracts.AbstractGameObject;
import enums.LocationType;

import maps.FSGameMap;
import maps.goldMan.GameCollection;

/**
 * Created by Miha on 19.02.2017.
 */
public class MapCreator {
    private static MapCreator ourInstance = new MapCreator();

    public static MapCreator getInstance() {
        return ourInstance;
    }

    public AbstractGameMap createMap(LocationType type, GameCollection gameCollection) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap(gameCollection);
                break;
            }
            case DB: {
                break;
            }
            default: throw new IllegalArgumentException("Cant create such map type " + type);
        }
        return obj;
    }
}
