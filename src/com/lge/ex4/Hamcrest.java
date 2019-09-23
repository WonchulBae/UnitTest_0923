package com.lge.ex4;

// Hamcrest Matcher
//  => 비교 표현의 확장 라이브러리
//    : 테스트 단언문을 작성할 때, 문맥적으로 자연스럽고 우아한 문장을 만들 수 있도록 해준다.
//  => 자연어에 가까운 테스트 단언 구문을 작성하도록 한다.
//  => jMock 라이브러리에서 독립해서, JUnit 4.4 이후로 정식 포함되었습니다.
//  => JUnit5에서는 기본으로 포함되지 않습니다.

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Hamcrest {
    @Test
    public void test1() throws Exception {
        Bank bank = new Bank();

        // assertEquals(100, bank.getBalance());
        // Hamcrest
        assertThat(bank.getBalance(), is(equalTo(100)));
        // Assert that bank.getBalance() is equal to 100
    }

    @Test
    public void test2() throws Exception {
        Bank bank = new Bank();

        // assertNotNull(bank.newBank());

        assertThat(bank.newBank(), is(notNullValue()));
    }

    @Test
    public void test3() throws Exception {
        Bank bank = new Bank();

        // assertTrue(bank.getAccountName().contains("guest"));

        assertThat(bank.getAccountName(), containsString("guest"));
    }
}

// SUT
class Bank {
    public int getBalance() {
        return 0;
    }

    public Bank newBank() {
        return null;
    }

    public String getAccountName() {
        return "";
    }
}







