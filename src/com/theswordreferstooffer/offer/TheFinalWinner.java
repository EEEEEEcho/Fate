package com.theswordreferstooffer.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TheFinalWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //参赛选手数量
        int m = scanner.nextInt();  //胜场要求
        if(n == 1){
            System.out.println(0);
        }
        if(m == 1){
            System.out.println(1);
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        //HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n;i ++){
            int fighter = scanner.nextInt();
            linkedList.add(fighter);
            //hashMap.put(fighter,0);
        }
        long count = 0;
        int firstWinner = -1;
        int tmpCount=1;
        while (true){
            int fighter1 = linkedList.get(0);
            int fighter2 = linkedList.get(1);
            count ++;
            if(fighter1 > fighter2){
                if(fighter1 == firstWinner){
                    tmpCount ++;
                    if(tmpCount == m){
                        System.out.println(count);
                        return;
                    }
                }
                else{
                    tmpCount = 1;
                    firstWinner = fighter1;
                }
                int tmp = linkedList.remove(1);
                linkedList.add(tmp);
            }
            else{
                if(fighter2 == firstWinner){
                    tmpCount ++;
                    if(tmpCount == m){
                        System.out.println(count);
                        return;
                    }
                }
                else{
                    tmpCount = 1;
                    firstWinner = fighter2;
                }
                int tmp = linkedList.remove(0);
                linkedList.add(tmp);
            }
        }
    }
}
