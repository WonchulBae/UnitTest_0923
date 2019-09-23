package com.lge.ex2;

import com.lge.ex1.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {
    public void testAdd_AddingTwoPlusTwo_DisplaysFour() throws Exception {
        Calculator calculator = new Calculator();

        calculator.add(2);
        calculator.add(2);

        assertEquals("2+2=4", 4, calculator.display());
    }

    public void testSub() throws Exception {
        Calculator calculator = new Calculator();

        calculator.sub(2);
        calculator.sub(2);

        assertEquals("-2-2=-4", -4, calculator.display());
    }
}
