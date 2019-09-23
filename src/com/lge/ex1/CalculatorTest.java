package com.lge.ex1;

// https://github.com/imguru/UnitTest_0923
//public class Program {
//    public static void main(String[] args) {
//        System.out.println("Hello, JUnit");
//    }
//}

// 단위테스트를 구성하는 일반적인 방법
//  => 클래스 별 테스트 케이스 클래스(Testcase class per class)
//  : 하나의 SUT에 대한 테스트 메소드를 하나의 테스트 케이스 클래스 안에 전부 집어 넣는다.

/*
import junit.framework.TestCase;

// JUnit3에서 테스트 케이스 클래스를 만드는 방법
public class CalculatorTest extends TestCase {

    // JUnit3 에서 테스트 메소드를 만드는 방법
    //  => testXXX
    public void testAdd() throws Exception {

    }
}
*/

import org.junit.Test;

import static org.junit.Assert.*;
// Assertion 메소드가 위의 패키지에 존재합니다.

// 테스트를 구성하는 방법 - 3A(TDD) vs BDD(행위 주도 개발)
// 1) Arrange(준비) / Given - 객체를 생성하고, 적절하게 설정한다.
// 2) Act(실행)     / When  - 객체에 작용을 가한다. 원하는 메소드를 호출한다.
// 3) Assert(단언)  / Then  - 기대하는 바를 단언한다.

// 테스트 코드의 품질 - Effective Unit Testing
//  1) 가독성
//     => 테스트 메소드 이름 / 테스트 실패 메세지
//  2) 유지보수성
//  3) 신뢰성

public class CalculatorTest {

    // public void testAdd() throws Exception {
    // ex) 대상메소드_시나리오_기대값
    @Test
    public void testAdd_2더하기2_결과는4() throws Exception {
    // public void testAdd_AddingTwoPlusTwo_DisplaysFour() throws Exception {
        // fail("작성 중입니다.");
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        calculator.add(2);
        calculator.add(2);

        // Assert
        // : 테스트 코드 안에서는 조건문이나 반복문이 존재하면 안된다.
        assertEquals("2+2=4", 4, calculator.display());
        // 인자의 순서에 주의해야 합니다.
        //   assertEquals([message], 기대값, 실제값);
        /*
        if (calculator.display() != 4) {
            fail("2+2 = 4");
        }
        */
    }
}



// SUT: System Under Test
// = CUT(Code/Class Under Test)
class Calculator {
    private int value;

    public Calculator() {
        value = 0;
    }

    public void add(int a) {
        value += a;
    }

    public void sub(int a) {
        value -= a;
    }

    public int display() {
        return 0;
    }
}