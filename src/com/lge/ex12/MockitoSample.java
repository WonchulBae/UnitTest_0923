package com.lge.ex12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Mock Framework는 단순히 행위 기반 검증의 기능만 제공하는 것이 아니라,
// Stub도 만들 수 있습니다.

class Point {
    private int x;
    private int y;

    String name() { return "Point"; }

    public void move(int x, int y) {
    }
}

public class MockitoSample {
    // when
    //  : 메소드의 결과를 변경할 때 사용하는 함수

    @Test
    public void stubTest() throws Exception {
       // Arrange
       when(mockedPoint.name()).thenReturn("Hello, Point");

       System.out.println(mockedPoint.name());
    }


    @Mock
    private List<String> mockedList;

    @Mock
    private Point mockedPoint;

    private SUT sut;

    @BeforeEach
    public void setUp() throws Exception {

        sut = new SUT();

        MockitoAnnotations.initMocks(this);
        // Field의 @Mock에 대해서 자동으로 생성해줍니다.

        // mockedList = createMock();
    }


    @SuppressWarnings("unchecked")
    private List<String> createMock() {
        return mock(List.class);
    }

    // verify - 순서를 확인하지 않습니다.
    //  => inOrder
    @Test
    public void kooTest() throws Exception {
        // List<String> mockedList = createMock();
        // SUT sut = new SUT();

        sut.koo(mockedList);

        InOrder inOrder = inOrder(mockedList);
        inOrder.verify(mockedList).add("first");
        inOrder.verify(mockedList).add("second");
        inOrder.verify(mockedList).add("third");
    }

    // - 호출 횟수 지정 방법
    // times(1): 정확한 횟수를 지정한다.
    // atLeast(N), atLeastOnce(): N번 이상
    // atMost(N), atMostOnce(): N번 이하

    // - 호출 인자
    //   anyXXX()
    //  : 인자는 상관하지 않고, 함수의 호출 여부만을 검증할 수 있습니다.
    @Test
    public void gooTest() throws Exception {
        // List<String> mockedList = createMock();
        // SUT sut = new SUT();

        sut.goo(mockedList);

        verify(mockedList, atLeastOnce()).add(anyString());

        // verify(mockedList, atLeastOnce()).add("once");
        // verify(mockedList, atMostOnce()).add("twice");
    }

    // 호출 여부
    @Test
    public void fooTest() throws Exception {
        // List<String> mockedList = createMock();
        // SUT sut = new SUT();

        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }

    @Test
    public void hooTest() throws Exception {
        sut.hoo(mockedPoint);

        verify(mockedPoint, atLeastOnce()).move(eq(10), anyInt());
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

    @Test
    public void hooTest() throws Exception {
        Point mockedPoint = mock(Point.class);
        SUT sut = new SUT();

        sut.hoo(mockedPoint);

        // verify(mockedPoint).move(10, 20);
        // verify(mockedPoint).move(10, 30);
        // verify(mockedPoint).move(10, 40);

        verify(mockedPoint).move(eq(10), anyInt());
    }

 */
}



class SUT {
    public void koo(List<String> s) {
        s.add("first");
        s.add("second");
        s.add("third");
    }

    public void hoo(Point point) {
        point.move(10, 20);
        point.move(10, 30);
        point.move(10, 40);
    }

    public void foo(List<String> s) {
        s.add("one");
        s.add("two");
    }

    public void goo(List<String> s) {
        s.add("once");
        s.add("once");
        s.add("twice");
        s.add("twice");
    }
}








