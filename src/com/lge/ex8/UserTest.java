package com.lge.ex8;

// Test Double Pattern
//  종류
// 1) Test Stub
// 2) Fake Object
// 3) Test Spy
// 4) Mock Object

import java.io.IOException;

public class UserTest {

}


// SUT
interface Connection {
    void move(int x, int y) throws IOException;
}

class TCPConnection implements Connection {
    @Override
    public void move(int x, int y) throws IOException {
        // TCP Socket
    }
}

class User {
    private Connection connection;

    public User(Connection connection) {
        this.connection = connection;
    }

    public void move(int x, int y) throws IOException {
        if (x < 0 || y > 0)
            throw new IllegalArgumentException();

        try {
            connection.move(x, y);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}














