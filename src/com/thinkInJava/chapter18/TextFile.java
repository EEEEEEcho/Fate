package com.thinkInJava.chapter18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            }
            finally {
                out.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")){
            remove(0);
        }
    }
    public TextFile(String fileName){
        this(fileName,"\n");
    }
    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for(String item : this){
                    out.println(item);
                }
            }
            finally {
                out.close();
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\TextFile.java");
        write("test.txt",file);
        TextFile textFile = new TextFile("text.txt");
        textFile.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(
                new TextFile("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\TextFile.java","\\W+")
        );
        System.out.println(words.headSet("a"));
    }
}
