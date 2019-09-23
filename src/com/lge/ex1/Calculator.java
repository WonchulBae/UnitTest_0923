package com.lge.ex1;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// SUT: System Under Test
// = CUT(Code/Class Under Test)
public class Calculator {
    private int value;

    // @Test
    // : 제품 클래스도 TestCase 클래스로 사용할 수 있다.

    static class TestCase {
        @Test
        public void testFoo() {

        }

        @Test
        public void testGoo() {

        }
    }

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
        return value;
    }
}
