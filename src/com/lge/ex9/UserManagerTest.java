package com.lge.ex9;

public class UserManagerTest {

}

// SUT
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface Database {
    void save(String name, User user);
    User load(String name);
}

class UserManager {
    private Database database;
    public UserManager(Database database) {
        this.database = database;
    }

    public void create(String name, int age) {
        if (database.load(name) != null) {
            return;
        }

        database.save(name, new User(name, age));
    }

    public User find(String name) {
        if (name == null)
            return null;

        return database.load(name);
    }
}






