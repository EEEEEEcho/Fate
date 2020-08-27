package com.echo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FindIndexMinmum {
    /*
    查找一个数组的第K小的数，注意同样大小算一样大。 如  2 1 3 4 5 2 第三小数为3
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0;i < n;i ++){
            hashSet.add(input.nextInt());
        }
        int k = input.nextInt();
        Object array[] =  hashSet.toArray();
        Arrays.sort(array);
        System.out.println(array[k-1]);
    }
}
