package objects;

import abstracts.AbstractGameObject;
import abstracts.AbstractMovingObject;
import enums.ActionResult;
import enums.GameObjectType;
import enums.MovingDirection;
import sounds.SoundObject;

/**
 * Created by Miha on 17.02.2017.
 */
public class Monster extends AbstractMovingObject implements SoundObject{

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/Images/monster_up.jpg"));
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN: {
                super.setIcon(getImageIcon("/Images/monster_down.jpg"));
                break;
            }
            case UP: {
                super.setIcon(getImageIcon("/Images/monster_up.jpg"));
                break;
            }
            case LEFT: {
                super.setIcon(getImageIcon("/Images/monster_left.jpg"));
                break;
            }
            case RIGHT: {
                super.setIcon(getImageIcon("/Images/monster_right.jpg"));
                break;
            }
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        switch (gameObject.getType()) {

            case TREASURE: {
                return ActionResult.NO_ACTION;
            }
            case MONSTER: {
                return ActionResult.NO_ACTION;
            }
            case GOLDMAN: {
                return ActionResult.DIE;
            }

        }

        return super.doAction(gameObject);
    }
    @Override
    public String getSoundName(ActionResult actionResult) {
        switch (actionResult) {
            case COLLECT_TREASURE: return "treasure.wav";
            case DIE: return "die.wav";
            case WIN: return "win.wav";
        }
        return null;
    }
}
