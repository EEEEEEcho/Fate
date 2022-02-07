package com.qiye;

import java.util.ArrayList;
import java.util.Scanner;

public class OperateStrGetMaxSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int op = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        //System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0;i < s.length();i ++){
            if(s.charAt(i) == 'a'){
                a.add(i);
            }
            else{
                b.add(i);
            }
        }
        //System.out.println(a);
        //System.out.println(b);
        int maxA = countA(a,b,op);
        int maxB = countA(b,a,op);
        System.out.println(Math.max(maxA,maxB));


    }
    public static int countA(ArrayList<Integer> a,ArrayList<Integer> b,int delete){
        int count = 1;
        for(int i = 0,j = 0;i < a.size() - 1;i ++){
            if(a.get(i) + 1 == a.get(i + 1)){
                count ++;
            }
            else{
                if(b.size() != 0 && delete != 0){
                    b.remove(j);
                    delete --;
                    count ++;
                    j++;
                }
            }
        }
        return count;
    }
}
