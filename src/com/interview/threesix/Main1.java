package com.interview.threesix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int operations = scanner.nextInt();
        scanner.nextLine();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < operations; i++) {
            int flg = scanner.nextInt();
            int end = scanner.nextInt();
            if (flg == 0){
                Arrays.sort(array,0,end);
            }
            else {
                Arrays.sort(array,0,end, Comparator.reverseOrder());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : array) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
