package objects;

import abstracts.AbstractGameObject;
import enums.GameObjectType;

/**
 * Created by Miha on 17.02.2017.
 */
public class Treasure extends AbstractGameObject {
    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/Images/gold.png"));
    }

    private int score = 10;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
