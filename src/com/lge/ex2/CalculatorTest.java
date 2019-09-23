package com.lge.ex2;

import com.lge.ex1.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// 픽스쳐 설치 방법 3. Implicit Setup/Tear down(암묵적 설치/해체)
//   => xUnit Test Framework 이 제공하는 기능을 사용합니다.
//   Pros: 테스트 코드 중복을 제거하고, 불필요한 상호 작용을 감출 수 있다.
//   Cons: 테스트 메소드의 인과 관계를 이해하기 어렵다.

// xUnit Test Framework이 테스트 메소드를 호출하는 순서
//  => 신선한 픽스쳐 전략
//  : 테스트 메소드를 실행하기 이전의 상태와 이후의 상태가 동일해야 한다.
//   - xUnit Test Pattern에서는 테스트를 구성하는 방법
//    : Four Phase Test Pattern(4단계 테스트 패턴)
//    1단계 - 픽스쳐를 설치하거나 관찰하기 위해 필요한 것을 집어넣는 작업
//    2단계 - SUT와 상호작용 한다.
//    3단계 - 기대 결과가 나왔는지 확인한다.
//   *4단계 - 픽스쳐를 해체해서, 테스트 이전 상태로 되돌려 놓는다.

// tc = new CalculatorTest();
// tc.setUp();
// tc.testAdd();
// tc.tearDown()

// tc = new CalculatorTest();
// tc.setUp();
// tc.testSub();
// tc.tearDown()

// TestCase Class = Test Suite Class
//                  ; 동일한 Fixture를 가지는 테스트 메소드의 집합


// https://github.com/imguru/UnitTest_0923
public class CalculatorTest {
    private Calculator calculator;

    public CalculatorTest() { System.out.println("TestCase()"); }

    @Before
    public void setUp() throws Exception {
        // System.out.println("setUp()");
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        // System.out.println("tearDown()");
    }

    @Test
    public void foo() {
        System.out.println("setUp");

        System.out.println("test");
        fail("실패");
        // 테스트 메소드 안에서 단언문이 실패할 경우, 이후의 코드는 수행되지 않습니다.

        // System.out.println("tearDown");
    }

    @Test
    public void testAdd_AddingTwoPlusTwo_DisplaysFour() throws Exception {
        System.out.println("testAdd()");
        calculator.add(2);
        calculator.add(2);

        assertEquals("2+2=4", 4, calculator.display());
    }

    @Test
    public void testSub() throws Exception {
        System.out.println("testSub()");
        calculator.sub(2);
        calculator.sub(2);

        assertEquals("-2-2=-4", -4, calculator.display());
    }
}



/*
// 픽스쳐 설치 방법 2. Delegate Setup(위임 설치)
//   : 테스트의 인과 관계를 쉽게 파악할 수 있을 뿐 아니라,
//     픽스쳐 설치에 대한 복잡함을 캡슐화함으로써, 각 테스트 메소드에 대한 이해도 쉽게 할 수 있다.
public class CalculatorTest {

    // Test Utility Method - Creation Method
    //  : 테스트 코드를 작성하면서 발생할 수 있는 중복을 최대한 별도의 메소드로 캡슐화하는 것이 좋다.
    private Calculator createCalc() {
        return new Calculator();
    }

    @Test
    public void testAdd_AddingTwoPlusTwo_DisplaysFour() throws Exception {
        Calculator calculator = createCalc();

        calculator.add(2);
        calculator.add(2);

        assertEquals("2+2=4", 4, calculator.display());
    }

    @Test
    public void testSub() throws Exception {
        Calculator calculator = createCalc();

        calculator.sub(2);
        calculator.sub(2);

        assertEquals("-2-2=-4", -4, calculator.display());
    }
}
*/



// 픽스쳐 설치 방법 1. Inline Fixture Setup
//  : 모든 픽스쳐 설치를 테스트 메소드 안에서 수행한다.
// Pros: 테스트의 인과 관계를 쉽게 파악할 수 있다.
// Cons: 모든 테스트 메소드 안에서 각각 설치해야 하므로,
//       1) '테스트 코드 중복'이 발생한다.
//       2) 픽스쳐 설치 과정이 복잡하면, 테스트 메소드를 이해하기 어렵게 만든다.

/*
public class CalculatorTest {
    @Test
    public void fooTest() {
        Calculator calculator = new Calculator();

        //...
    }


    @Test
    public void testAdd_AddingTwoPlusTwo_DisplaysFour() throws Exception {
        Calculator calculator = new Calculator();

        calculator.add(2);
        calculator.add(2);

        assertEquals("2+2=4", 4, calculator.display());
    }

    @Test
    public void testSub() throws Exception {
        Calculator calculator = new Calculator();

        calculator.sub(2);
        calculator.sub(2);

        assertEquals("-2-2=-4", -4, calculator.display());
    }
}
*/