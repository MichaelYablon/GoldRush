/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import abstracts.AbstractGameObject;
import enums.GameObjectType;

/**
 *
 * @author Miha
 */
public class Exit extends AbstractGameObject{
    public Exit(Coordinate coordinate) {
        super.setType(GameObjectType.EXIT);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/Images/exit.gif"));
    }
    
}
