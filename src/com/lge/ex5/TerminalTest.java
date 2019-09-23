package com.lge.ex5;

import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TerminalTest {
    private static Terminal terminal;

    @BeforeAll
    public static void setUpTestCase() throws Exception {
        System.out.println("setUpTestCase");
        terminal = new Terminal();
        terminal.connect();
    }

    @AfterAll
    public static void tearDownTestCase() throws Exception {
        System.out.println("tearDownTestCase");
        terminal.disconnect();
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("setUp");
//        terminal = new Terminal();
//        terminal.connect();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("tearDown");
//        terminal.disconnect();
    }

    @Test
    public void loginTest() throws Exception {
        System.out.println("loginTest");
        terminal.login("guest", "password");

        assertTrue(terminal.isLogin());
    }

    @Test
    public void logoutTest() throws Exception {
        System.out.println("logoutTest");
        terminal.login("guest", "password");
        terminal.logout();

        assertFalse(terminal.isLogin());
    }
}

/*
import org.junit.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

// 만약 connect() / disconnect() 느리다면..
//  : 만약 픽스쳐를 설치하거나 해체하는 작업이 느리다면,
//  => Slow Test Problem
//   : 테스트가 너무 느려서, 개발자들이 SUT가 변경되어도, 매번 테스트를 자동으로 수행하지 않는다.
//     테스트가 개발자의 생산성을 떨어뜨린다.

//  => Suite Fixture SetUp / TearDown
//   : 이제는 각각의 테스트가 더 이상 독립적이지 않다.
//    - 공유 픽스쳐 전략
//     : 빠르지만, 픽스쳐의 상태에 따라서 '변덕스러운 테스트'가 발생할 수 있다.
//    => 테스트의 신뢰성

// TerminalTest.setUp();     // static
// TerminalTest tc = new TerminalTest();
// tc.setUp();
// tc.loginTest();
// tc.tearDown();

// TerminalTest tc = new TerminalTest();
// tc.setUp();
// tc.logoutTest();
// tc.tearDown();
// TerminalTest.tearDown();  // static

public class TerminalTest {
    private static Terminal terminal;

    @BeforeClass
    public static void setUpTestCase() throws Exception {
        System.out.println("setUpTestCase");
        terminal = new Terminal();
        terminal.connect();
    }

    @AfterClass
    public static void tearDownTestCase() throws Exception {
        System.out.println("tearDownTestCase");
        terminal.disconnect();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
//        terminal = new Terminal();
//        terminal.connect();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
//        terminal.disconnect();
    }

    @Test
    public void loginTest() throws Exception {
        System.out.println("loginTest");
        terminal.login("guest", "password");

        assertTrue(terminal.isLogin());
    }

    @Test
    public void logoutTest() throws Exception {
        System.out.println("logoutTest");
        terminal.login("guest", "password");
        terminal.logout();

        assertFalse(terminal.isLogin());
    }
}
*/

/*
public class TerminalTest {
    @Test
    public void loginTest() throws Exception {
        Terminal terminal = new Terminal();
        terminal.connect();

        terminal.login("guest", "password");

        assertTrue(terminal.isLogin());

        terminal.disconnect();
    }

    @Test
    public void logoutTest() throws Exception {
        Terminal terminal = new Terminal();
        terminal.connect();

        terminal.login("guest", "password");
        terminal.logout();

        assertFalse(terminal.isLogin());

        terminal.disconnect();
    }
}
*/


// SUT
class Terminal {
    public void connect() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    public void disconnect() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    public void login(String id, String password) {
    }

    public void logout() {
    }

    public boolean isLogin() {
        return true;
    }
}
