package com.lge.ex3;


import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest2 {
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
