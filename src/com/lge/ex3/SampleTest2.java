package com.lge.ex3;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest2 {

    @Test
    public void assertTest() throws Exception {
        double a = 0.7;
        double b = 0.1 * 7;

        assertEquals(a, b, 0.00001); // !!!
    }


    @DisplayName("2더하기 2는 4의 결과가 나오지는 검증하는 테스트입니다.")
    @Test
    public void testAdd() throws Exception {

    }

    @Disabled(value = "작성중입니다.")
    @Test
    public void badTest() throws Exception {
        // fail("작성중입니다.");
    }

    void foo() throws Exception {
        TimeUnit.SECONDS.sleep(3);
    }

    // foo() 함수는 2초 안에 수행되어야만 합니다.
    @Test
    public void fooTest() throws Exception {
        // 시간을 측정하는 부분도, 단언 메소드를 통해 제공됩니다.
        assertTimeout(Duration.ofNanos(1 * 1000 * 1000 * 1000), () -> {
            foo();
        });
    }


    static public Integer parseInt(String value)
            throws NumberFormatException {
        // return Integer.parseInt(value);
        throw new InvalidParameterException("");
        // return 42;
    }

    @Test
    public void parseIntTest() {
        String bad = "x16";

        assertThrows(NumberFormatException.class, () -> {
            parseInt(bad);
        });
    }
}
