package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.List;

public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int start = 0;
        int count = 0;
        while (start < data.length){
            int top = data[start];
            if (top > 255) return false;
            String topStr = toBinaryString(top);
            int i = countOne(topStr);
            if (i > 4) return false;
            if (i == 1 && count == 0) return false;
            if (i == 0){
                start ++;
            }
            else{
                count = i - 1;
                start ++;
                while (start < data.length && toBinaryString(data[start]).startsWith("10") && count > 0){
                    start ++;
                    count --;
                }
                if (count > 0) return false;
            }
        }
        return true;
    }
    private int countOne(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') return count;
            count ++;
        }
        return count;
    }
    public String toBinaryString(int num){
        String s = Integer.toBinaryString(num);
        if (s.length() < 8){
            int appNum = 8 - s.length();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < appNum; i++) {
                sb.append("0");
            }
            s = sb.append(s).toString();
        }
        return s;
    }
    public static void main(String[] args) {
//        ValidUtf8 v = new ValidUtf8();
//        v.validUtf8(new int[]{240,162,138,147,145});

//        System.out.println(v.toBinaryString(145));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer integer1 = list.stream().reduce((integer, integer2) -> integer | integer2).get();
        System.out.println(integer1);
    }
}
