package com.lge.ex8;

// Test Double Pattern
//  종류
// 1) Test Stub
// 2) Fake Object
// 3) Test Spy
// 4) Mock Object

// Test Stub Pattern
// => 다른 컴포넌트로부터의 간접 입력에 의존하는 로직을 독립적으로 검증하고 싶다.
//  : 실제 의존하는 객체를 테스트용 객체로 교체해서, SUT가 테스트하는데 필요한 결과를 보내도록
//    설계한다.
//  => 특수한 상황을 시뮬레이션한다.
//   : 시간, 네트워크, 환경 ....

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BadConnection implements Connection {
    @Override
    public void move(int x, int y) throws IOException {
        throw new IOException("Broken pipe");
    }
}


public class UserTest {
    // 1. x, y가 잘못된 인자가 전달되었을 때, 예외가 발생하는지 여부를 검증하고 싶다.

    // @Test(expected=IllegalArgumentException.class) - JUnit 4
    @Test
    public void moveTest() throws Exception {
        int badX = -1;
        int badY = -1;
        User user = new User(new TCPConnection());

        assertThrows(IllegalArgumentException.class, () -> {
            user.move(badX, badY);
        });
    }

    // 2. 네트워크 연결이 존재하지 않을 경우,
    //    move에서 IOException이 발생하는지 여부를 검증하고 싶다.
    @Test
    public void moveTest_badConnection() throws Exception {
        User user = new User(new BadConnection());

        assertThrows(IOException.class, () -> {
            user.move(10, 32);
        });
    }


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
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();

        try {
            connection.move(x, y);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}














