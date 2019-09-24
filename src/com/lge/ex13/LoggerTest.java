package com.lge.ex13;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() throws Exception {
        String filename = "good_file.log";
        IFileSystemManager stub = mock(IFileSystemManager.class);
        when(stub.isValid(filename)).thenReturn(true);
        Logger logger = new Logger(stub);

        boolean actual = logger.isValidFilename(filename);

        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }

    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() throws Exception {
        String filename = "bad.log";
        IFileSystemManager stub = mock(IFileSystemManager.class);
        when(stub.isValid(filename)).thenReturn(true);
        Logger logger = new Logger(stub);

        assertFalse("파일명이 다섯글자 미만일 때", logger.isValidFilename(filename));
    }
}

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

    public Logger() {
        manager = new FileSystemManager();
    }

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