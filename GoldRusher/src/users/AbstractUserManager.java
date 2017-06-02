package users;

/**
 * Created by Miha on 23.02.2017.
 */
public abstract class AbstractUserManager implements UserManager{
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createNewUser(String name) {
        user = new User(name);
    }
}
