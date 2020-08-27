package com.qiye;

import java.util.ArrayList;
import java.util.Scanner;

public class NumReSort {
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        while (count > 0){
            list.clear();
            String s = scanner.nextLine();
            int x = Integer.parseInt(s);
            boolean flg = false;
            permutation(s.toCharArray(),0);
            for(String num : list){
                if(Integer.parseInt(num) % x == 0 && !num.equals(s)){
                    flg = true;
                    break;
                }
            }
            if(flg){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
            count --;
        }

//        for(String s : list){
//            System.out.println(s);
//        }
    }
    public static void permutation(char array[],int i){
        if(array == null || i < 0 || i > array.length){
            return;
        }
        if(i == array.length - 1){
            list.add(new String(array));
            //System.out.println();
        }
        else{
            for(int j = i;j < array.length;j ++){
                char temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                permutation(array,i+1);
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
    }
}
