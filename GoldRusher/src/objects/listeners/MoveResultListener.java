package objects.listeners;

import abstracts.AbstractMovingObject;
import enums.ActionResult;
import objects.GoldMan;

/**
 * Created by Miha on 22.02.2017.
 */
public interface MoveResultListener {

    public void notifyActionResult(ActionResult actionResult, AbstractMovingObject movingObject);

}
