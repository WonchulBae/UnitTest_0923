package com.lge.ex12;

import org.junit.Test;

import static org.mockito.Mockito.*;

// * Mockito 에서는
//   mock / spy는 동일합니다.
//   mock은 실제로 호출이 발생하지 않고, spy는 호출이 발생합니다.

interface MP3 {
    // Interface도 기본 구현을 가질 수 있습니다.
    //  defender method
    default void playMusic() {
        System.out.println("Play music MP3");
    }
}

class User {
    void play(MP3 mp3) { mp3.playMusic(); }
}

public class UserTest {
    @Test
    public void mockTest() throws Exception {
        MP3 mockedMp3 = mock(MP3.class);
        User user = new User();

        user.play(mockedMp3);

        verify(mockedMp3).playMusic();
    }

    @Test
    public void spyTest() throws Exception {
        MP3 mockedMp3 = spy(MP3.class);
        User user = new User();

        user.play(mockedMp3);

        verify(mockedMp3).playMusic();
    }
}
