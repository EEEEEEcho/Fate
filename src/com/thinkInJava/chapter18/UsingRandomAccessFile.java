package com.thinkInJava.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() throws IOException{
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for(int i = 0;i < 7;i ++){
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException{
        //文件不存在会直接创建
        RandomAccessFile rf = new RandomAccessFile(file,"rw");
        for(int i = 0;i < 7;i ++){
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file,"rw");
        rf.seek(5 * 8); //一个double占8个字节，寻找第40个字节的位置，也就是第5个double的位置
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
