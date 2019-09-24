package com.lge.ex14;

import com.lge.ex13.User2;
import org.junit.Test;

import java.lang.reflect.Field;

// SUT의 필드나 메소드가 protected로 되어 있어서 읽을 수 없는 경우,
// 테스트 전용 하위 클래스를 이용합니다.


class TestUser extends User2 {
    public int getAge() {
        return age;
    }
}

class User {
    private int age = 42;
}

public class SampleTest {
    @Test
    public void refTest() throws Exception {
        // 'Reflection'을 이용해서 private 필드 값을 읽을 수 있습니다.
        User user = new User();
        Class clazz = user.getClass();
        Field field = clazz.getDeclaredField("age");

        field.setAccessible(true); // private
        int age = (int) field.get(user);

        System.out.println(age);
    }


    @Test
    public void userTest() {
        TestUser user = new TestUser();
        System.out.println(user.getAge());
    }
}








