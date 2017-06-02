package objects;

import java.io.Serializable;

/**
 * Created by Miha on 24.02.2017.
 */
public class User implements Serializable {
    protected int id;
    protected String username;

    public User() {
    }



    public User(String username) {
        this.username = username;
    }



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
