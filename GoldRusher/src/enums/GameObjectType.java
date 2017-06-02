/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.io.Serializable;

/**
 *
 * @author Miha
 */
public enum GameObjectType implements Serializable{


    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDMAN(1),
    NOTHING(-1);
    
    private int indexPriority;

    public int getIndexPriority() {
        return indexPriority;
    }

    private GameObjectType(int indexPriority) {
        this.indexPriority = indexPriority;
    }
    
}
