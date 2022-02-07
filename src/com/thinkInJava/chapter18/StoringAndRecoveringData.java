package com.thinkInJava.chapter18;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        dataOutputStream.writeDouble(3.1415926);
        dataOutputStream.writeUTF("This is PI");
        dataOutputStream.writeDouble(1.1415926);
        dataOutputStream.writeUTF("Square root of 2");
        dataOutputStream.close();
        /**
         * 如果使用DataOutputStream，那么就可以使用DataInputStream读取数据，无论平台如何。
         */
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());
    }
}
