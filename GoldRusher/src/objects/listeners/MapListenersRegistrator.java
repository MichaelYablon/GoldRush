package objects.listeners;

import maps.goldMan.GameCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 23.02.2017.
 */
public abstract class MapListenersRegistrator implements GameCollection{

    private ArrayList<MoveResultListener> listeners = new ArrayList<>();

    @Override
    public List<MoveResultListener> getMoveListeners() {
        return listeners;
    }

    @Override
    public void addMoveListener(MoveResultListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeMoveListener(MoveResultListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeAllLMoveisteners() {
        listeners.clear();
    }
}
