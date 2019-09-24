package com.lge.ex11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


// - SUT의 메소드를 호출하였을 때, 발생하는 부수 효과를 관찰할 수 없어,
//   테스트 안된 요구사항을 검증하고 싶다.
//  => Mock Object(모의 객체)

// 테스트 수행 방법 2가지
//  1) State Verification(상태 검증)
//  : 테스트에 검증할 수 있는 상태가 존재할 때 사용하는 방법
//  2) Behavior Verification(행위 검증)
//  : 올바른 로직 수행의 판단의 근거로 특정한 동작의 수행 여부를 검증하는 방법
//    - 호출 여부
//    - 호출 횟수
//    - 호출 순서
//    - 호출 인자
//   => Mock Framework
//   => Java: jMock, EasyMock, 'Mockito', Spock(Groovy)
//       C++: Google Mock

// Mockito
//   => Test Double을 동적으로 생성할 수 있습니다.

public class DLogTest {
    @Test
    public void writeTest() throws Exception {
        // Arrange
        Target mock1 = mock(Target.class);
        Target mock2 = mock(Target.class);
        Level level = Level.INFO;
        String message = "test-log-message";
        DLog log = new DLog();
        log.addTarget(mock1);
        log.addTarget(mock2);

        // Act
        log.write(level, message);

        // Assert
        //  : mock1, mock2에 대해서 write가 제대로 호출되었는지 여부를 검증한다.
        verify(mock1).write(level, message);
        verify(mock2).write(level, message);
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
