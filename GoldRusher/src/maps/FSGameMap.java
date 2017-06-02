package maps;

import abstracts.AbstractGameMap;
import abstracts.AbstractGameObject;
import creators.GameObjectCreator;
import enums.GameObjectType;

import maps.goldMan.GameCollection;
import objects.Coordinate;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 17.02.2017.
 */
public class FSGameMap extends AbstractGameMap {

    public FSGameMap(){
        super();
    }

    public FSGameMap(GameCollection gameCollection) {
        super(gameCollection);
    }
    @Override
    public boolean loadMap(Object source) {
        File file = new File(source.toString());
        if (!file.exists()) throw new IllegalArgumentException("filename must not be empty");

        try {
            setExitExist(false);
            setGoldManExist(false);

            setHeight(getLineCount(file));

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = reader.readLine().trim();
            setName(str.split(",")[0]);

            setTimeLimit(Integer.valueOf(str.split(",")[1]));
            setWidth(Integer.valueOf(str.split(",")[2]));

            int x = 0;
            int y = 0;

            while ((str = reader.readLine()) != null) {
                x = 0;

                for (String s : str.split(",")) {
                    createGameObject(s, new Coordinate(x, y));
                    x++;
                }
                y++;
            }
            if (!isValidMap()) {
                throw new Exception("The map is not valid!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void createGameObject(String s, Coordinate coordinate) {
        GameObjectType type = GameObjectType.valueOf(s.toUpperCase());

        AbstractGameObject  newObj = GameObjectCreator.getInstance().createObject(type, coordinate);

        getGameCollection().addGameObject(newObj);

        if (newObj.getType() == GameObjectType.EXIT) {
            setExitExist(true);
        }
        else if (newObj.getType() == GameObjectType.GOLDMAN) {
            setGoldManExist(true);
        }
    }

    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1;
        } catch (IOException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return lineCount;
    }

    @Override
    public boolean saveMap(Object source) {
        return false;
    }

//    @Override
//    public boolean drawMap() {
//        return false;
//    }
}
