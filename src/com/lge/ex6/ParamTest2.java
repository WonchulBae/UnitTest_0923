package com.lge.ex6;

// Parameterized Test -> Test Factory

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ParamTest2 {

    // dynamicTest: Runtime에 테스트를 생성할 수 있는 함수.
    @TestFactory
    public Stream<DynamicTest> primeTest() throws Exception {
        return Stream.of(2, 3, 5, 7, 11, 13)
                .map(s -> dynamicTest("param: " + s, () -> {
                    assertTrue(Util.isPrime(s));
                }));
    }

    @Test
    public void fooTest() {

    }


}
