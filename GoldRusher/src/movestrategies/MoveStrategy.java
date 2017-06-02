package movestrategies;

import abstracts.AbstractGameObject;
import abstracts.AbstractMovingObject;
import enums.MovingDirection;
import maps.goldMan.GameCollection;

/**
 * Created by Miha on 23.02.2017.
 */
public interface MoveStrategy {
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection);
}
