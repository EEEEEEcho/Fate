package com.code.codertop;

public class MyAtoi {
    public int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;

        char head = s.charAt(0);
        if ((head == '-' || head == '+') && s.length() >= 2){
            head = s.charAt(1);
        }
        if (head > '9' || head < '0') return 0;

        StringBuilder sb = new StringBuilder();
        char op = '*';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c == '-')){
                op = c;
            }
            else if(c >= '0' && c <= '9'){
                sb.append(c);
            }
            else{
                break;
            }
        }
        long result = 0;
        int pow = sb.length();
        sb.reverse();
        for (int i = 0; i < pow; i++) {
            result += (sb.charAt(i) - 48) * Math.pow(10,i);
        }

        if (op == '-'){
            result = -result;
            if (result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args) {

    }
}
