package enums;

import java.io.Serializable;

/**
 * Created by Miha on 19.02.2017.
 */
public enum LocationType implements Serializable{
    FS(1),
    DB(2);

    private int indexPriority;

    public int getIndexPriority() {
        return indexPriority;
    }

    private LocationType(int indexPriority) {
        this.indexPriority = indexPriority;
    }
}
