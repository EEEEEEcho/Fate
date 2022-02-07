package com.qiye;

import java.util.*;

public class DeepBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s == ""){
            System.out.println(0);
        }
        else{
            char array[] = s.toCharArray();
            int max = 0;
            int count = 0;
            for(int i=0;i < array.length;i ++){
                if(array[i] == '('){
                    count ++;
                    max = Math.max(count,max);
                }
                else{
                    count --;
                }
            }
            System.out.println(max);
        }

    }
}
