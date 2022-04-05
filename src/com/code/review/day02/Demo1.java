package com.code.review.day02;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        s.nextLine();
        for (int i = 0; i < cases; i++) {
            String numStr = s.nextLine();
            int num = Integer.parseInt(numStr);
            if(num % 11 == 0 || hasEleven(numStr)){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
    }
    private static boolean hasEleven(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                count ++;
                if (count == 2){
                    return true;
                }
            }
        }
        return false;
    }
}
