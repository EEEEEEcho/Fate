package com.interview.cs;

public class Main2 {
    public boolean isPalindrome (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                sb.append(Character.toLowerCase(c));
            }
        }
        int i = 0;
        int j = sb.length() - 1;
        while (i <= j){
            char m = sb.charAt(i);
            char n = sb.charAt(j);
            if (m != n){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

}
