package creators;

import abstracts.AbstractGameObject;
import enums.GameObjectType;
import objects.*;

/**
 * Created by Miha on 19.02.2017.
 */
public class GameObjectCreator {

    private static GameObjectCreator ourInstance;

    public static GameObjectCreator getInstance() {
        if (ourInstance == null) ourInstance = new GameObjectCreator();
        return ourInstance;
    }

    private GameObjectCreator() {
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        AbstractGameObject object = null;

        switch (type) {
            case NOTHING: {
                object = new Nothing(coordinate);
                break;
            }
            case WALL: {
                object = new Wall(coordinate);
                break;
            }
            case MONSTER: {
                object = new Monster(coordinate);
                break;
            }
            case TREASURE: {
                object = new Treasure(coordinate);
                break;
            }
            case EXIT: {
                object = new Exit(coordinate);
                break;
            }
            case GOLDMAN: {
                object = new GoldMan(coordinate);
                break;
            }

            default: throw new IllegalArgumentException("Cant create object type " + type);
        }
        return object;
    }
}
