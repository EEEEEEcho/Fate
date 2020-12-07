package com.thinkInJava.chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    /**
     * 使用available方法检查还有多少可用字符
     * available:在没有阻塞的情况下所能读取的字节数
     * @param args
     */
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\TestEOF.java")
                )
        );
        while (dataInputStream.available() != 0){
            System.out.println((char)dataInputStream.readByte());
        }
    }
}
