package com.thinkInJava.chapter18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(bFile));
        try{
            byte[] data = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(data);
            return data;
        }
        finally {
            bufferedInputStream.close();
        }
    }
    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsolutePath());
    }
    
}
