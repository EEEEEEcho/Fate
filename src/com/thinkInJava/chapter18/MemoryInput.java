package com.thinkInJava.chapter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        /**
         * BufferedInputFile.read()读入的String结果被用来创建一个StringReader
         * 然后调用read每次读取一个字符，
         */
        StringReader in = new StringReader(BufferedInputFile.read("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1){
<<<<<<< HEAD
            System.out.print((char)c);
=======
            System.out.println((char)c);
>>>>>>> 0a3bd63289606aa1d11bb5719d7de5bebb6fd4b6
        }
    }
}
