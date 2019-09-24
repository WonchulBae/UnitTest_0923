package com.lge.ex10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

// SUT의 메소드를 호출하였을 때, 발생하는 부수 효과를 관찰할 수 없어,
// 테스트 안된 요구사항을 검증하고 싶다.
// => Test Spy Pattern
//   : 목격한 일을 기록해두었다가, 나중에 테스트에서 확인할 수 있도록 만들어진 테스트 대역.

class SpyTarget implements Target {
    private List<String> logs = new ArrayList<>();

    private String concat(Level level, String message) {
        return level.name() + "@" + message;
    }

    @Override
    public void write(Level level, String message) {
        logs.add(concat(level, message));
    }

    // 테스트를 위한 메소드를 제공해야 합니다.
    public boolean isReceived(Level level, String message) {
        return logs.contains(concat(level, message));
    }
}


public class DLogTest {
    @Test
    public void writeTest() throws Exception {
        DLog log = new DLog();
        SpyTarget spy1 = new SpyTarget();
        SpyTarget spy2 = new SpyTarget();
        Level level = Level.INFO;
        String message = "log_test_message";

        log.write(level, message);

        assertTrue(spy1.isReceived(level, message));
        assertTrue(spy2.isReceived(level, message));
    }
}

// SUT
enum Level {
    INFO, WARN, ERROR
}

interface Target {
    void write(Level level, String message);
}

class DLog {
    private List<Target> targets = new ArrayList<>();
    public void addTarget(Target target) {
        targets.add(target);
    }

    public void write(Level level, String message) {
        for (Target e : targets)
            e.write(level, message);
    }
}









