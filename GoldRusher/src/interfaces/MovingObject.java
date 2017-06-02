/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enums.ActionResult;
import enums.MovingDirection;
import javax.swing.ImageIcon;
import abstracts.AbstractGameObject;

/**
 *
 * @author Miha
 */
public interface MovingObject extends StaticObject{


    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject);

    int getStep();
    
//    ImageIcon getIconLeft();
//    ImageIcon getIconRight();
//    ImageIcon getIconUp();
//    ImageIcon getIconDown();


}
