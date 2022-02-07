package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class RedAndGreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char array[] = s.toCharArray();
        int res = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i < array.length;i ++){
            count = 0;
            for(int j=0;j < i;j ++){
                if(array[j] != 'R') count ++;
            }
            for(int j=i+1;j < array.length;j ++){
                if(array[j] != 'G') count ++;
            }
            res = Math.min(res,count);
        }
        System.out.println(res);
    }
}
