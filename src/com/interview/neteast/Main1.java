package com.interview.neteast;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.nextLine();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int index = num % k;
            map.put(index, map.getOrDefault(index, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }
        System.out.println(max);
    }
}
