package com.lge.ex3;


import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest2 {
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
