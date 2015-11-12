package fr.xebia.unittestwithdagger;

/**
 * Created by florentchampigny on 12/11/2015.
 */
public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
