package objects.listeners;

import enums.ActionResult;
import objects.GoldMan;

import java.util.List;

/**
 * Created by Miha on 22.02.2017.
 */
public interface MoveResultNotifier {

    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    public void removeMoveListener(MoveResultListener listener);

    public void removeAllLMoveisteners();

    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan);

}
