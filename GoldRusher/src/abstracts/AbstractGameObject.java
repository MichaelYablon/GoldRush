/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracts;

import objects.*;
import enums.GameObjectType;
import interfaces.StaticObject;
import javax.swing.ImageIcon;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Miha
 */
public abstract class AbstractGameObject implements StaticObject, Serializable{
    
    private GameObjectType type;
    private Coordinate coordinate;
    
    private ImageIcon icon = getImageIcon("/Images/noicon.png");

    protected AbstractGameObject() {
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
    }
         
    protected ImageIcon getImageIcon(String path) {

        return new ImageIcon(getClass().getResource(path));
    }

    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 37 * hash + Objects.hashCode(this.coordinate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractGameObject other = (AbstractGameObject) obj;
        return true;
    }

    @Override
    public String toString() {
        return "AbstractGameObject{" +
                "type=" + type +
                ", coordinate=" + coordinate +
                ", icon=" + icon +
                '}';
    }
}
