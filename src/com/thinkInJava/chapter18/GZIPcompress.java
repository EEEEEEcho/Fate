package com.thinkInJava.chapter18;//: io/GZIPcompress.java
// {Args: GZIPcompress.java}

import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
    public static void main(String[] args)
            throws IOException {

        BufferedReader in = new BufferedReader(
                new FileReader("rtest.dat"));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);
    }
} /* (Execute to see output) *///:~
