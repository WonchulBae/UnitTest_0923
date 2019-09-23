package com.lge.ex3;

import org.junit.Ignore;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

// JUnit 4의 기능
public class SampleTest {
    // 4. 배열 비교 단언문 / 부동 소수점 비교
    @Test
    public void assertTest() throws Exception {
        double a = 0.7;
        double b = 0.1 * 7;

        assertEquals(a, b, 0.00001);

        String[] name1 = { "42", "Tom" };
        String[] name2 = { "42", "Tom" };

        // assertEquals(name1, name2); // Wrong!!!
        assertArrayEquals(name1, name2);
    }


    // 3. 테스트 비활성화
    //  : 전체 테스트의 결과에 영향을 주지 않고,
    //    비활성화한 테스트가 존재해야 한다는 사실은 알아야 한다.
    @Ignore(value = "작성중입니다.")
    @Test
    public void badTest() throws Exception {
        // fail("작성중입니다.");
    }

    // 2. 비기능 테스트
    //    : 시간(성능)
    void foo() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    // foo() 함수는 2초 안에 수행되어야만 합니다.
    @Test(timeout = 2000)
    public void fooTest() throws Exception {
        foo();
    }


    static public Integer parseInt(String value)
            throws NumberFormatException {
        return Integer.parseInt(value);
        // throw new InvalidParameterException("");
        // return 42;
    }

    // 1. 예외 테스트 기능
    // : parseInt라는 함수에 잘못된 형식의 문자열을 보냈을 때, NumberFormatException 이
    //   발생하는지 여부를 검증하고 싶다.
    @Test(expected = NumberFormatException.class)
    public void parseIntTest_junit4() throws Exception {
        String bad = "x16";

        parseInt(bad);
    }

    @Test
    public void parseIntTest_junit3() throws Exception {
        String bad = "x16";

        try {
            parseInt(bad);
            fail("예외가 발생하지 않음.");
        } catch (NumberFormatException e) {
            // Succeed
            assertTrue(true);
        } catch (Exception e) {
            fail("다른 종류의 예외가 발생하였습니다.");
        }
    }
}

