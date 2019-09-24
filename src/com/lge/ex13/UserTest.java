package com.lge.ex13;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class BadConnection implements Connection {
    @Override
    public void move(int x, int y) throws IOException {
        throw new IOException("Broken pipe");
    }
}

public class UserTest {
    @Test
    public void moveTest_badConnection() throws Exception {
        Connection stub = mock(Connection.class);
        doThrow(new IOException("Broken pipe"))
                .when(stub).move(anyInt(), anyInt());
        // 함수의 반환값이 void인 경우 바로 사용할 수 없습니다.
        User user = new User(stub);

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














