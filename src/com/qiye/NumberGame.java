package com.qiye;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String sb[] = new String[n];
        for(int i=0;i < n;i ++){
            String s = scanner.next();
            sb[i] = getSortString(s);

        }
//        for(String s : sb){
//            System.out.println(s);
//        }
        int max = Integer.parseInt(sb[0]);
        for(int i = 0;i < n; i ++){
            int now = Integer.parseInt(sb[i]);
            if(max < now){
                max = now;
            }
        }
        System.out.println(max);
    }
    public static String getSortString(String s){
        char array[] = s.toCharArray();
        Arrays.sort(array);
        String result = "";
        for(Character character : array){
            result += character;
        }
        return result;
    }
}
