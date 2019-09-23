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


// 문제점
// 1) 복잡하다.
//   : xUnit Test Framework 마다 사용하는 방법이 다릅니다.
// 2) 테스트의 실패의 경우 원인 데이터가 무엇인지 알기 어렵다.
//   : @Parameterized.Parameters(name = "{index} - v:{0}, e:{1}")
//   => 테스트의 이름을 변경하는 기능을 'JUnit4'에서 제공하고 있습니다.
// 3) TestCase 클래스를 별도로 작성해야 합니다.
//   : SUT에서 일반적인 테스트와 파라미터화테스트가 동시에 필요할 경우, 별도의 테스트 케이스 클래스를
//     작성해야 합니다.


@RunWith(value = Parameterized.class)
public class ParamTest {
    // Object[]: reflection을 통해 객체를 생성할 때, 생성자의 인자를 전달하는 타입.
    // Data Set 정의
    @Parameterized.Parameters(name = "{index} - v:{0}, e:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {3, true},
                {5, false},
                {7, true},
                {11, true},
                {13, true},
                {4, false},
                {8, false},
                {9, false},
                {12, false},
        });
    }

    // 생성자 정의
    private int value;
    private boolean expected;
    public ParamTest(int value, boolean expected) {
        this.value = value;
        this.expected = expected;
    }

    // 이제는 입력된 데이터를 기반으로 다양한 테스트 메소드를 작성하면 됩니다.
    @Test
    public void primeTest() throws Exception {
        // System.out.println("value: " + value);
        // assertTrue(Util.isPrime(value));
        assertEquals(expected, Util.isPrime(value));
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

    public static boolean isPrime(int value) {
        for (int i = 2; i <= value; ++i) {
            if (value % i == 0 && i != value) {
                return false;
            }
        }

        return true;
    }
}

