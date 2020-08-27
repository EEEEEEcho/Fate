package com.theswordreferstooffer.offer;

public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if(str.equals("") || str == null){
            return "";
        }
        String tmp = new String(str);
        str = str.substring(n);
        for(int i=0;i < n;i ++){
            str += tmp.charAt(i);
        }
        return str;
    }

    public static void main(String[] args) {
        LeftRotateString l = new LeftRotateString();
        l.leftRotateString("",1);
    }
}
