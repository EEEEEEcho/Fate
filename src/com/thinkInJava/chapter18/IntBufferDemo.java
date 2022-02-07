package com.thinkInJava.chapter18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        IntBuffer intBuffer = buffer.asIntBuffer();
        //存储一个数组的int
        intBuffer.put(new int[]{11,42,47,99,143,811,1016});
        //通过绝对位置进行读写
        System.out.println(intBuffer.get(3));
        intBuffer.put(3,1811);
        //重置指针
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}
