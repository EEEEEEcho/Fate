package com.thinkInJava.chapter13;
//import net.mindview.util;
public class Hex {
    public static String format(byte[] data){
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(byte b : data){
            if(n % 16 == 0){
                //统计了16个字节，加行头
                sb.append(String.format("%05X: ",n));
            }
            sb.append(String.format("%02X ",b));
            n++;
            if(n % 16 == 0){
                //统计了16个字节，加行尾部换行
                sb.append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(format(new byte[256]));
    }
}
