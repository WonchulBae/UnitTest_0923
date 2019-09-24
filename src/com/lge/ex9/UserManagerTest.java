package com.lge.ex9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//  => Fake Object Patterns
// 1) 아직 만들어지지 않은 컴포넌트에 의존하는 객체를 검증하고 싶다.
// 2) 의존 객체가 너무 느려서, 테스트하기 힘들다.
// 3) 의존 객체를 사용하기 어려울 때 사용할 수 있다.
//  : SUT가 의존하는 컴포넌트를 훨씬 가겹게 구현된 것으로 바꾼다.

// 문제점
//  : 테스트 코드의 유지보수성이 떨어질 수 있다.

class FakeDatabase implements Database {
    private Map<String, User> data = new HashMap<>();

    @Override
    public void save(String name, User user) {
        data.put(name, user);
    }

    @Override
    public User load(String name) {
        return data.get(name);
    }
}


public class UserManagerTest {
    @Test
    public void createTest() throws Exception {
        String name = "Tom";
        int age = 42;
        UserManager manager = new UserManager(new FakeDatabase());
        User expected = new User(name, age);

        manager.create(name, age);

        assertEquals(expected, manager.find(name));
    }
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






