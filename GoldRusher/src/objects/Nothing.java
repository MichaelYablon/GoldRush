package objects;

import abstracts.AbstractGameObject;
import enums.GameObjectType;

/**
 * Created by Miha on 17.02.2017.
 */
public class Nothing extends AbstractGameObject {
    public Nothing(Coordinate coordinate) {
        super.setType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
        super.setIcon(null);
    }
}
