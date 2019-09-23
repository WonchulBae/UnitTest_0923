package com.lge.ex3;


import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

// JUnit 4의 기능
public class SampleTest {
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

