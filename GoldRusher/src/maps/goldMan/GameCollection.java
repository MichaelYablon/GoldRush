package maps.goldMan;

import abstracts.AbstractGameObject;
import enums.GameObjectType;
import enums.MovingDirection;
import movestrategies.MoveStrategy;
import objects.Coordinate;
import objects.listeners.MoveResultNotifier;

import java.util.List;

/**
 * Created by Miha on 23.02.2017.
 */
public interface GameCollection extends MoveResultNotifier {

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);

    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getAllGameObjects();

    List<AbstractGameObject> getGameObjects(GameObjectType type);

    void moveObject(MovingDirection direction, GameObjectType gameObjectType);

    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);

    void clear();

    //void moveObjectRandom(GameObjectType objectType);

}
