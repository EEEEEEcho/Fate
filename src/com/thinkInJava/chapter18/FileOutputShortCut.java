package com.thinkInJava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortCut {
    static String inputFile = "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\FileOutputShortCut.java";
    static String outputFile = "G:\\Fate\\FileOutputShortCut.txt";
    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFile.read(inputFile));
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        //进行改造
        PrintWriter out = new PrintWriter(outputFile);
        int lineCount = 1;
        String s;
        while ((s = bufferedReader.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outputFile));
    }
}
