package com.thinkInJava.chapter18;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        //第二个参数代表是否自动清空
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello world");
    }
}
