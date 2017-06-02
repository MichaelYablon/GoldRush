package maps;

import abstracts.AbstractGameMap;

/**
 * Created by Miha on 17.02.2017.
 */
public class DBGameMap extends AbstractGameMap {
    @Override
    public boolean loadMap(Object source) {
        return false;
    }

    @Override
    public boolean saveMap(Object source) {
        return false;
    }

    //@Override
    public boolean drawMap() {
        return false;
    }

}
