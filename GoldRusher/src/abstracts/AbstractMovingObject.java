/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracts;

import enums.ActionResult;
import objects.*;
import enums.MovingDirection;
import interfaces.MovingObject;
import javax.swing.ImageIcon;

/**
 *
 * @author Miha
 */
public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject{

    public abstract void changeIcon(MovingDirection direction);


    private int step = 1;

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    protected void actionBeforeMove(MovingDirection direction) {
        changeIcon(direction);
    }

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        actionBeforeMove(direction);
        return doAction(gameObject);
    }

    public ActionResult doAction(AbstractGameObject gameObject) {
        if (gameObject == null) {
            return ActionResult.NO_ACTION;
        }
        switch (gameObject.getType()) {
            case NOTHING: {
                return ActionResult.MOVE;
            }
            case WALL: {
                return ActionResult.NO_ACTION;
            }
        }

        return ActionResult.NO_ACTION;
    }

    public Coordinate getDirectionCoordinate(MovingDirection direction) {


        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {
            case UP: {
                newCoordinate.setY(y - this.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + this.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - this.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + this.getStep());
                break;
            }
        }

        return newCoordinate;


    }

}
