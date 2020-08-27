package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class MakeTringle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[3];
        for(int i=0;i < 3;i ++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if(array[0] + array[1] > array[2]){
            int sum = array[0] + array[1] + array[2];
            System.out.println(sum);
        }
        else{
            array[2] = array[1] + array[0] - 1;
            System.out.println(array[0] + array[1] + array[2]);
        }
    }
}
