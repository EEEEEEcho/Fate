package com.thinkInJava.chapter19;
enum Search{
    HITHER,YON
}
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum e = Search.HITHER; //向上转型
        //  e.values(); 没有values方法了已经
        for (Enum en : e.getClass().getEnumConstants()){
            System.out.println(en);
        }
    }
}
