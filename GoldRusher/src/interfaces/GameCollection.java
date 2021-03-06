package interfaces;

import abstracts.AbstractGameObject;
import enums.ActionResult;
import enums.GameObjectType;
import enums.MovingDirection;
import objects.Coordinate;
import objects.listeners.MoveResultListener;
import objects.listeners.MoveResultNotifier;

import java.util.List;

/**
 * Created by Miha on 21.02.2017.
 */
public interface GameCollection{

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);

    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getAllGameObjects();

    List<AbstractGameObject> getGameObjects(GameObjectType type);

    ActionResult moveObject(MovingDirection direction, GameObjectType gameObjectType);

}
