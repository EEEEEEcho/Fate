package com.qiye;

import java.util.HashMap;
import java.util.Scanner;

public class TodayIsWhichDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(1,31);
            map.put(2,28);
            map.put(3,31);
            map.put(4,30);
            map.put(5,31);
            map.put(6,30);
            map.put(7,31);
            map.put(8,31);
            map.put(9,30);
            map.put(10,31);
            map.put(11,30);
            map.put(12,31);
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                map.put(2,29);
            }
            int result = 0;
            if(month == 1){
                result = day;
                System.out.println(result);
            }
            else{
                for(int i = 1; i< month;i ++){
                    result += map.get(i);
                }
                result += day;
                System.out.println(result);
            }
        }
    }
}
