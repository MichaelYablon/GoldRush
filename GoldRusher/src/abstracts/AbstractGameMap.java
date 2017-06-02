package abstracts;

import abstracts.AbstractGameObject;
import enums.ActionResult;
import enums.GameObjectType;
import enums.MovingDirection;

import interfaces.GameMap;
import maps.goldMan.GameCollection;
import objects.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 17.02.2017.
 */
public abstract class  AbstractGameMap implements GameMap, Serializable{

    private static final long serialVersionUID = 1L;
    private int height;
    private int width;
    private int timeLimit;
    private String name;
    private boolean isExitExist;
    private boolean isGoldManExist;
    private GameCollection gameCollection;

//    //Зберігає всі обєкти з координатами
//    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
//
//    //Зберігає список обєктів для кожного типу
//    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    public AbstractGameMap() {
    }

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public boolean isExitExist() {
        return isExitExist;
    }

    public void setExitExist(boolean isExitExist) {
        this.isExitExist = isExitExist;
    }

    public boolean isGoldManExist() {
        return isGoldManExist;
    }

    public void setGoldManExist(boolean isGoldManExist) {
        this.isGoldManExist = isGoldManExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        // приоритет объекта зависит от номера индекса объекта enum
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject; // сокращенная запись условия if: если первый объект имеет больший приоритет - вернуть его, иначе вернуть второй объект
    }

    public boolean isValidMap() {
        return isGoldManExist && isExitExist; // если есть и вход и выход - карта валидна
    }

    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

}
