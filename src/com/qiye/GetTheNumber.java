package com.qiye;

import java.util.Scanner;

public class GetTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = "";
        for(int i=0;i < s.length();i ++){
            char tmp = s.charAt(i);
            if(tmp >= 48 && tmp <= 57){
                result += tmp;
            }
        }
        System.out.println(result);
    }
}
