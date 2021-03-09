package forum.model;

import java.util.Arrays;

public class Admin extends User{

    protected boolean superUser;

    public Admin(String userName, String pass) {
        super(userName, pass);
        this.superUser = false;
    }

    public boolean isSuperUser() {
        return superUser;
    }

    @Override
    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "superUser=" + superUser +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
