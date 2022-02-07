package com.qiye;

import java.util.HashMap;
import java.util.Scanner;

public class ChangeAtoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int key = 0;
        int index = 0;
        while (index < s.length()){
            if(s.charAt(index) == 'a'){
                index ++;
            }
            else {
                map.put(key,index);
                key ++;
                index ++;
            }
        }
        System.out.println(map);
    }
}
