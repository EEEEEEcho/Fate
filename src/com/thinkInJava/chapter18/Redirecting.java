package com.thinkInJava.chapter18;//: io/Redirecting.java
// Demonstrates standard I/O redirection.

import java.io.*;

public class Redirecting {
    public static void main(String[] args)
            throws IOException {
        //1.定义console为标准输出流
        PrintStream console = System.out;
        //2.创建输入流
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\Redirecting.java"));
        //3.创建输出流
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("test.out")));
        //4.重新设置输入流
        System.setIn(in);
        //5.重新设置输出流
        System.setOut(out);
        //6.重新设置错误流
        System.setErr(out);
        //7.将重新设置的输入流再进行包装
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        //8.开始读
        String s;
        while ((s = br.readLine()) != null)
            //这里是将读入的流中的数据，重新打印到了重新设置的输出流上
            System.out.println(s);
        //9.关闭输出流
        out.close(); // Remember this!
        //10.重新设置输出流
        System.setOut(console);
    }
} ///:~
