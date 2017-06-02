package objects;

import abstracts.AbstractGameObject;
import enums.GameObjectType;

/**
 * Created by Miha on 17.02.2017.
 */
public class Wall extends AbstractGameObject {
    public Wall(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.WALL);
        super.setIcon(getImageIcon("/Images/wall.png"));
    }
}
