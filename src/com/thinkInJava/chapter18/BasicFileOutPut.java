package com.thinkInJava.chapter18;

import java.io.*;

public class BasicFileOutPut {
<<<<<<< HEAD
    static String fileOutput = "G:\\Fate\\BasicFileOutput.txt";
    static String fileInput = "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\BasicFileOutPut.java";
    public static void main(String[] args) throws IOException {
        //输入流
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(fileInput)));
        //输出流
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileOutput)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            /**
             * 既写入文件，也打印，该程序执行完后，该源代码的每一行前面都会加上行号
             */
            out.println(lineCount++ + " : " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(fileOutput));
=======
    static String file = "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\BasicFileOutPut.java";
    public static void main(String[] args) throws IOException {
        // 创建字符串输入流
        StringReader in = new StringReader(BufferedInputFile.read(file));
        // 把字符串输入流放到缓冲流中
        BufferedReader reader = new BufferedReader(in);
        // 创建一个输出流
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = reader.readLine()) != null){
            /**
             * 既写入文件，也打印，该程序执行完后，该源代码的每一行前面都会加上行号
             */
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
>>>>>>> 0a3bd63289606aa1d11bb5719d7de5bebb6fd4b6

    }
}
