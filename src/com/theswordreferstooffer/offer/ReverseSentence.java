package com.theswordreferstooffer.offer;

public class ReverseSentence {
    public String reverseSentence(String str) {
        //这里有个问题 如果字符串为" ",那么应该输出" ".但是 使用if(str.equals(" "))无法判断。
        //根本进不去if语句。所以使用str.trim().length() == 0 来判断
        if(str == null || str.length() == 0 || str.trim().length() == 0){
            return str;
        }
        String blank = " ";
        if (str.equals(blank)) {
            System.out.println(str.length());
            return " ";
        }
        String[] strings = str.split(" ");
        String result = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                result += strings[i];
            }
            result += strings[i] + " ";
        }

        //System.out.println(result);
        return result.trim();
    }

    public static void main(String[] args) {
//        ReverseSentence r = new ReverseSentence();
//        String re = r.reverseSentence(" ");
//        System.out.println(re);

    }
}
