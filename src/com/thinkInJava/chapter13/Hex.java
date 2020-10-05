package com.thinkInJava.chapter13;
//import net.mindview.util;
public class Hex {
    public static String format(byte[] data){
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(byte b : data){
            if(n % 16 == 0){
                sb.append(String.format("%05X: ",n));
            }
            sb.append(String.format("%02X ",b));
            n++;
            if(n % 16 == 0){
                sb.append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        if(args.length == 0){
            //System.out.println(format(Binary));
        }
    }
}
