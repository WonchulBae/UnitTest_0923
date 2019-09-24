package com.lge.ex12;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SUT {
    public void foo(List<String> s) {
        s.add("one");
        s.add("two");
    }
}

public class MockitoSample {
    @Test
    public void fooTest_stateCheck() throws Exception {
        List<String> s = new ArrayList<>();
        SUT sut = new SUT();

        sut.foo(s);

        assertEquals("one", s.get(0), "0번째");
        assertEquals("two", s.get(1), "1번째");
    }


    @Test
    public void fooTest() throws Exception {
        List<String> mockedList = mock(List.class);
        SUT sut = new SUT();

        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }
}










