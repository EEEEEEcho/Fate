package com.thinkInJava.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF;
    static FileChannel fc;
    private static class LockAndModify extends Thread{
        private ByteBuffer bf;
        private int start,end;
        LockAndModify(ByteBuffer mbb,int start,int end){
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            bf = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                //执行加锁
                FileLock fileLock = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (bf.position() < bf.limit() - 1){
                    bf.put((byte) (bf.get() + 1));
                }
                fileLock.release();
                System.out.println("Released: " + start + " to " + end);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        fc = new RandomAccessFile("rtest.dat","rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for(long i = 0;i < LENGTH;i ++){
            out.put((byte)'x');
        }
        new LockAndModify(out,0,0 + LENGTH / 3);
        new LockAndModify(out,LENGTH / 2,LENGTH / 2 + LENGTH / 4);
    }
}
