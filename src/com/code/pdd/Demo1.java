package com.code.pdd;

import java.util.*;

public class Demo1 {
    public static ArrayDeque<Integer> list = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int house = scanner.nextInt();
        System.out.println("house:" + house);
        int mills = scanner.nextInt();
        System.out.println("mills:" + mills);
        scanner.nextLine();
        int[] millArr = new int[mills];
        for (int i = 0; i < mills; i++) {
            millArr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(millArr));
        dfs(millArr,0,1,0,house);
        System.out.println(list);
        System.out.println(list.stream().min(Comparator.comparingInt(o -> o)));
    }
    private static void dfs(int[] mills,int i,int select,int count,int n){
        if(i == mills.length){
            list.add(count);
        }
        else{
            for (int j = i; j < mills.length; j++) {
                if (mills[j] == select){
                    count++;
                    for (int k = 1; k <= n; k++) {
                        if(k != select){
                            dfs(mills,j + 1,k,count,n);
                        }
                    }
                }
            }
        }
    }
}
