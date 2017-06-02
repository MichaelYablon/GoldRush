package maps;

import abstracts.NewAbstracts.AbstractGameMap;
import abstracts.AbstractGameObject;
import abstracts.AbstractMovingObject;
import creators.MapCreator;
import enums.ActionResult;
import enums.GameObjectType;
import enums.LocationType;
import interfaces.DrawableMap;

import interfaces.TimeMap;
import maps.goldMan.GameCollection;
import movestrategies.AgressiveMoving;
import objects.Coordinate;
import objects.GoldMan;
import objects.Nothing;
import objects.Wall;
import objects.listeners.MoveResultListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 19.02.2017.
 */
public class JTableGameMap extends AbstractGameMap implements TimeMap {

    private transient JTable jTableMap = new JTable();

    private transient String[] columnNames;

    private transient AbstractGameObject[][] mapObjects;

    private transient TimeMover timeMover = new TimeMover();

    public JTableGameMap() {
        try {
            jTableMap.setEnabled(false);
            jTableMap.setSize(new Dimension(310,316));
            jTableMap.setRowHeight(26);
            jTableMap.setRowSelectionAllowed(false);
            jTableMap.setShowHorizontalLines(false);
            jTableMap.setShowVerticalLines(false);
            jTableMap.setTableHeader(null);
            jTableMap.setUpdateSelectionOnSort(false);
            jTableMap.setVerifyInputWhenFocusTarget(false);
        } catch (Exception e) {
            Logger.getLogger(JTableGameMap.class.getName()).log(Level.SEVERE, null, e);
        }


    }



    private void fillEmptyMap(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapObjects[y][x] = new Nothing(new Coordinate(x, y));
            }
        }
    }

    private void updateObjectsArray() {

        mapObjects = new AbstractGameObject[mapInfo.getHeight()][mapInfo.getWidth()];

        fillEmptyMap(mapInfo.getWidth(), mapInfo.getHeight());

        for (AbstractGameObject gameObj : getGameCollection().getAllGameObjects()) {
            if (!gameObj.getType().equals(GameObjectType.NOTHING)) {
                int y = gameObj.getCoordinate().getY();
                int x = gameObj.getCoordinate().getX();
                if(!(mapObjects[y][x] instanceof Nothing) & !(mapObjects[y][x] instanceof Wall)) {
                    AbstractGameObject tmpObj = mapObjects[y][x];
                    mapObjects[y][x] = getPriorityObject(tmpObj, gameObj);
                } else {
                    mapObjects[y][x] = gameObj;
                }
            }
        }
    }


    @Override
    public Component getMap() {
        return jTableMap;
    }


    @Override
    public boolean drawMap() {

        updateObjectsArray();

        try {

            columnNames = new String[mapInfo.getWidth()];

            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }

            jTableMap.setModel(new DefaultTableModel(mapObjects, columnNames));

            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Component getMapComponent() {
        return jTableMap;
    }

    @Override
    public void start() {
        timeMover.start();
    }

    @Override
    public void stop() {
        timeMover.stop();
    }

    private class TimeMover implements ActionListener{

        private Timer timer;
        private final static int MOVING_PAUSE = 500;
        private final static int INIT_PAUSE  = 1000;

        private TimeMover() {
            timer = new Timer(MOVING_PAUSE, this);
            timer.setInitialDelay(INIT_PAUSE);
        }

        public void start() {
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getGameCollection().moveObject(new AgressiveMoving(), GameObjectType.MONSTER);
        }

//        @Override
//        public void notifyActionResult(ActionResult actionResult, AbstractMovingObject movingObject) {
//            switch (actionResult){
//                case DIE: case WIN:{
//                    timer.stop();
//                    break;
//                }
//            }
//        }
    }
}
