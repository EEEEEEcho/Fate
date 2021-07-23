package com.thinkInJava.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    /**
     * 读取格式化数据，使用DataInputStream，它是一个面向字节的I/O类，必须使用InputStream，
     * 而不是Reader类。，我们可以使用InputStream以字节的形式读取任何数据
     */
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    //必须为ByteArrayInputStream提供字节数组，为了产生该数组String包含了一个可以实现此项工作的
                    //getByte()方法。所产生的ByteArrayInputStream是一个适合传递给DataInputStream的InputStream
                    new ByteArrayInputStream(BufferedInputFile.read(
                            "G:\\Fate\\src\\com\\thinkInJava\\chapter18\\FormattedMemoryInput.java"
                    ).getBytes())
            );
            while (true){
                System.out.print((char)in.readByte());
                System.out.println((char)in.readByte());
            }
        }
        catch (EOFException e){
            e.printStackTrace();
        }
    }
}
