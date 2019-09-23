package com.lge.ex6;

// Parameterized Test(파라미터화 테스트)
//  : xUnit Test Framework에서 지원해야 사용할 수 있습니다.
//  정의: 입력 데이터를 바꿔가면서, 수차례 반복 검사하는 데이터 중심 테스트의 중복을 없애주는 기법.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

// 2, 3, 5, 7, 11

// 1. Test Runner가 다르게 동작합니다.
//   => @RunWith(value = Parameterized.class)

// 2. 정적 배열로 데이터를 정의해야 합니다.
// 3. 생성자의 인자로 전달되는 데이터를 정의해야 합니다.

// TestCase tc = new TestCase(2);
// tc.setUp();
// tc.testAdd();
// tc.tearDown();

// TestCase tc = new TestCase(3);
// tc.setUp();
// tc.testAdd();
// tc.tearDown();

// TestCase tc = new TestCase(5);
// tc.setUp();
// tc.testAdd();
// tc.tearDown();


@RunWith(value = Parameterized.class)
public class ParamTest {
    // Object[]: reflection을 통해 객체를 생성할 때, 생성자의 인자를 전달하는 타입.
    // Data Set 정의
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2},
                {3},
                {5},
                {7},
                {11},
                {13}
        });
    }

    // 생성자 정의
    private int value;
    public ParamTest(int value) {
        this.value = value;
    }

    // 이제는 입력된 데이터를 기반으로 다양한 테스트 메소드를 작성하면 됩니다.
    @Test
    public void primeTest() throws Exception {
        System.out.println("value: " + value);
        assertTrue(Util.isPrime(value));
    }


}

/*
public class ParamTest {
    // 단언 메소드는 실패할 경우 이후의 코드를 수행하지 않는다.
    // => 하나의 테스트 메소드 안에서 여러개의 단언문을 사용할 경우,
    //    죽은 단언문 문제가 발생합니다.
    //  Google Test
    //     EXPECT_TRUE(isPrime(2));
    //     EXPECT_TRUE(isPrime(3));

    @Test
    public void primeTest() throws Exception {
        assertTrue(Util.isPrime(2));
        assertTrue(Util.isPrime(3));
        assertTrue(Util.isPrime(5));
        assertTrue(Util.isPrime(7));
        assertTrue(Util.isPrime(11));
    }

    @Test
    public void primeTest1() throws Exception {
        assertTrue(Util.isPrime(2));
    }

    @Test
    public void primeTest2() throws Exception {
        assertTrue(Util.isPrime(3));
    }
}
*/


final class Util {
    private Util() {
    }

    static boolean isPrime(int value) {
        for (int i = 2; i <= value; ++i) {
            if (value % i == 0 && i != value) {
                return false;
            }
        }

        return true;
    }
}

