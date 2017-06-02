package database;

import score.DbScoreSaver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Miha on 24.02.2017.
 */
public class SQLiteConnection {

    private SQLiteConnection() {
    }

    private static SQLiteConnection instance;

    public static SQLiteConnection getInstance() {
        if (instance == null) instance = new SQLiteConnection();
        return instance;
    }

    private Connection con;
    private String path = "db/GoldMan.db";

    public Connection getConnection() {
        try {
            if (con == null) {

                //Динамічна реєстрація драйвера JDBC
                Class.forName("org.sqlite.JDBC").newInstance();

                //Створюємо підключення до бази даних
                String url = "jdbc:sqlite:" + path;

                con = DriverManager.getConnection(url);
            }

            return con;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DbScoreSaver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void closeConnection() {
        try {
            con.close();
            con = null;
        } catch (Exception e) {
            Logger.getLogger(DbScoreSaver.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
