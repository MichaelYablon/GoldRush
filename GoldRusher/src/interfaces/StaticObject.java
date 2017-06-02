/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enums.GameObjectType;
import javax.swing.ImageIcon;
import objects.Coordinate;

/**
 *
 * @author Miha
 */
public interface StaticObject {
    
    //Кожен обєкт має іконку
    ImageIcon getIcon();
    
    //координати обєкта
    Coordinate getCoordinate();
    
    //Тип обєкта з перечислення
    GameObjectType getType();
}
