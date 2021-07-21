package com.thinkInJava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortCut {
<<<<<<< HEAD
    static String inputFile = "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\FileOutputShortCut.java";
    static String outputFile = "G:\\Fate\\FileOutputShortCut.txt";
    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFile.read(inputFile));
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        //进行改造
        PrintWriter out = new PrintWriter(outputFile);
=======
    static String file = "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\FileOutputShortCut.java";

    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFile.read(file));
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        //进行改造
        PrintWriter out = new PrintWriter(file);
>>>>>>> 0a3bd63289606aa1d11bb5719d7de5bebb6fd4b6
        int lineCount = 1;
        String s;
        while ((s = bufferedReader.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
<<<<<<< HEAD
        System.out.println(BufferedInputFile.read(outputFile));
=======
        System.out.println(BufferedInputFile.read(file));
>>>>>>> 0a3bd63289606aa1d11bb5719d7de5bebb6fd4b6
    }
}
