package com.lge.ex7;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() throws Exception {
        String filename = "good_file.log";
        Logger logger = new Logger();

        boolean actual = logger.isValidFilename(filename);

        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }

    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() throws Exception {
        String filename = "bad.log";
        Logger logger = new Logger();

        assertFalse("파일명이 다섯글자 미만일 때", logger.isValidFilename(filename));
    }


}


// SUT
class FileSystemManager {
    public boolean isValid(String filename) {
        // ...
        return true;
    }
}

class Logger {
    // file.log
    //  : file의 이름이 5글자 이상이어야 한다.
    public boolean isValidFilename(String filename) {
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;

        FileSystemManager manager = new FileSystemManager();
        return manager.isValid(filename);
    }
}