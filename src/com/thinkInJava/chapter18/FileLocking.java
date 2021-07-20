package com.thinkInJava.chapter18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("Data.txt");
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null){
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(1000);
            fileLock.release();
            System.out.println("Release Lock");
        }
        fileOutputStream.close();
    }
}
