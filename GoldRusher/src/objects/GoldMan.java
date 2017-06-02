/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import abstracts.AbstractGameObject;
import abstracts.AbstractMovingObject;
import enums.ActionResult;
import enums.GameObjectType;
import enums.MovingDirection;
import sounds.SoundObject;

/**
 *
 * @author Miha
 */
public class GoldMan extends AbstractMovingObject implements SoundObject{

    private int totalScore = 0;
    private int turnsNumber = 0;

    public GoldMan(Coordinate coordinate) {
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/Images/goldman_up.png"));

    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addTotalScore(int totalScore) {
        this.totalScore += totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }



    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {
        turnsNumber++;

        switch (gameObject.getType()) {

            case MONSTER: {
                return ActionResult.DIE;
            }
            case TREASURE: {
                totalScore += ((Treasure) gameObject).getScore();
                return ActionResult.COLLECT_TREASURE;
            }
            case EXIT: {
                totalScore *=2;
                return ActionResult.WIN;
            }
        }
        return super.doAction(gameObject);
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case UP: {
                super.setIcon(getImageIcon("/Images/goldman_up.png"));
                break;
            }
            case DOWN: {
                super.setIcon(getImageIcon("/Images/goldman_down.png"));
                break;
            }
            case RIGHT: {
                super.setIcon(getImageIcon("/Images/goldman_right.png"));
                break;
            }
            case LEFT: {
                super.setIcon(getImageIcon("/Images/goldman_left.png"));
                break;
            }
        }
    }

    @Override
    public String getSoundName(ActionResult actionResult) {
        switch (actionResult) {
            case DIE: return "die.wav";
            case WIN: return "win.wav";
            //case COLLECT_TREASURE: return "treasure.wav";
        }
        return null;
    }
}
