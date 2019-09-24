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

    public void goo(List<String> s) {
        s.add("once");
        s.add("twice");
        s.add("twice");
    }
}

public class MockitoSample {

    // times(1): 정확한 횟수를 지정한다.
    // atLeast(N), atLeastOnce: N번 이상
    // atMost(N), atMostOnce: N번 이하
    @Test
    public void gooTest() throws Exception {
        List<String> mockedList = mock(List.class);
        SUT sut = new SUT();

        sut.goo(mockedList);

        verify(mockedList).add(anyString());

        // verify(mockedList, atLeastOnce()).add("once");
        // verify(mockedList, atMostOnce()).add("twice");
    }

    @Test
    public void fooTest() throws Exception {
        List<String> mockedList = mock(List.class);
        SUT sut = new SUT();

        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }

/*
    @Test
    public void fooTest_stateCheck() throws Exception {
        List<String> s = new ArrayList<>();
        SUT sut = new SUT();

        sut.foo(s);

        assertEquals("one", s.get(0), "0번째");
        assertEquals("two", s.get(1), "1번째");
    }
 */
}










