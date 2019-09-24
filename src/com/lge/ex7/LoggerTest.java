package com.lge.ex7;

import org.junit.Test;

import static org.junit.Assert.*;

// 결과가 정해져 있는 테스트 대역 - Stub
//            "테스트 전용 클래스"
class StubFileSystem implements IFileSystemManager {
    @Override
    public boolean isValid(String filename) {
        return true;
    }
}

public class LoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() throws Exception {
        // Given
        String filename = "good_file.log";
        Logger logger = new Logger(new StubFileSystem());

        // When
        boolean actual = logger.isValidFilename(filename);

        // Then
        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }

    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() throws Exception {
        String filename = "bad.log";
        Logger logger = new Logger(new StubFileSystem());

        assertFalse("파일명이 다섯글자 미만일 때", logger.isValidFilename(filename));
    }
}

// SUT
// : 현재의 아래 코드는 테스트 대역을 적용할 수 없는 설계 방식입니다.
// => 느슨한 결합(약한 결합)

// * Logger와 FileSystemManager는 '강한 결합'이므로, 테스트 대역으로 교체할 수 없습니다.
// '강한 결합': 협력 객체를 이용할 때, 구체적인 타입을 직접 사용하는 것을 의미합니다.
// '약한 결합': 협력 객체를 이용할 때, 인터페이스나 추상 타입을 통해 이용해야 합니다.
//    + 협력 객체를 직접 생성하면 안됩니다.
//      new 연산은 강한 결합을 발생하는 연산입니다.
//      => 협력 객체를 외부에서 생성해서 전달 받아야 합니다.
//        : DI(Dependency Injection): 의존성 주입
//      * 의존성 주입 2가지
//       1) 생성자 주입
//         : 협력 객체가 필수적일 때
//       2) 메소드 주입
//         : 협력 객체가 메소드를 호출할 때만 필요할 때

//      * 의존성 주입 문제점
//        -> 보일러플레이트: 반드시 필요하지만, 반복적으로 발생하는 코드
//       Logger -> FileSystemManager, LoggerManager

//        => 보일러플레이트를 해결하기 위해서, 의존성 주입 프레임워크를 사용하는 것이 좋습니다.
//          Java: Dagger2

/*
    fsManager = new FileSystemManager();
    logManager = new LoggerManager();

    logger = new Logger(fsManager, logManager);
*/

interface IFileSystemManager {
    boolean isValid(String filename);
}

class FileSystemManager implements IFileSystemManager {
    @Override
    public boolean isValid(String filename) {
        // ext, NTFS, hfs, ...
        return false;
    }
}

class Logger {
    private IFileSystemManager manager;
    public Logger(IFileSystemManager manager) {
        this.manager = manager;
    }

    // 기존의 코드의 수정없이, 동작하도록...
    public Logger() {
        manager = new FileSystemManager();
    }

    // file.log
    //  : file의 이름이 5글자 이상이어야 한다.
    public boolean isValidFilename(String filename) {
        //-------------
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;
        //-------------

        // IFileSystemManager manager = new FileSystemManager();
        return manager.isValid(filename);
    }
}