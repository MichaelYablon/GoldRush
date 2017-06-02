package maps;

import abstracts.AbstractGameObject;
import abstracts.AbstractMovingObject;
import enums.ActionResult;
import enums.GameObjectType;
import enums.MovingDirection;
import interfaces.GameCollection;
import objects.Coordinate;
import objects.GoldMan;
import objects.Nothing;


import java.util.*;

/**
 * Created by Miha on 21.02.2017.
 */
public class MapCollection implements GameCollection {

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<GameObjectType, ArrayList<AbstractGameObject>>(GameObjectType.class);

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {
        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) tmpList = new ArrayList<>();

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);
    }



    @Override
    public ActionResult moveObject(MovingDirection direction, GameObjectType type) {

        ActionResult actionResult = null;

        for (AbstractGameObject gameObject : this.getGameObjects(type)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                Coordinate newCoordinate = getNewCoordinate(direction, movingObject);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);

                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        swapObjects(movingObject, new Nothing(newCoordinate));
                        break;
                    }

                }
            }
        }
        return actionResult;
    }


    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        swapCoordinates(obj1, obj2);

        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);
    }

    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

    private Coordinate getNewCoordinate(MovingDirection direction, AbstractMovingObject movingObject) {
        int x = movingObject.getCoordinate().getX();
        int y = movingObject.getCoordinate().getY();

        Coordinate newCoordinate = new Coordinate(x, y);

        switch (direction) { //Визначаємо напрямок руху
            case UP: {
                newCoordinate.setY(y - movingObject.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + movingObject.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - movingObject.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + movingObject.getStep());
                break;
            }
        }
        return newCoordinate;
    }

}
