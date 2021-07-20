package com.thinkInJava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception{
        FileChannel in = new FileInputStream("data.txt").getChannel();
        FileChannel out = new FileOutputStream("dataout.txt").getChannel();
        //从第0个字节开始，将in.size()数量的内容传输到out流中
        in.transferTo(0,in.size(),out);
    }
}
