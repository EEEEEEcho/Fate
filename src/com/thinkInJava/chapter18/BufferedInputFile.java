package com.thinkInJava.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
//    public static String read(String filename) throws IOException{
//        //使用String或File对象作为文件名传送给FileReader，打开一个文件作为字符输入
//        //为了提高速度，对该文件进行缓冲，所以要将产生的引用传给BufferedReader构造器
//        //BufferedReader提供了readLine()方法，当readLine()返回null时，就到了文件末尾
//        BufferedReader in = new BufferedReader(new FileReader(filename));
//        String s;
//        StringBuilder sb = new StringBuilder();
//        while ((s = in.readLine()) != null){
//            sb.append(s + "\n");
//        }
//        in.close();
//        return sb.toString();
//
//    }
//
//    public static void main(String[] args) throws Exception{
//        System.out.println(read("C:\\Users\\Echo\\Desktop\\nginx.conf"));
//    }

    public static String read(String fileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null){
            stringBuilder.append(s + "\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException{

        System.out.println(read("G:\\Fate\\src\\com\\thinkInJava\\chapter18\\BufferedInputFile.java"));

        System.out.println(read("BufferedInputFile.java"));
    }
}
