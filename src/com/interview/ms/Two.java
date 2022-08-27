package com.interview.ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Two {
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(X);
        int count = 1;
        int n = X.length;
        if (n == 1) return 1;
        int start = X[0];
        int end = start + W;
        for (int x : X) {
            if (x >= start && x <= end) {
                continue;
            }
            count++;
            start = x;
            end = start + W;
        }
        return count;

    }

    public static void main(String[] args) {
//        Two two = new Two();
//        int solution = two.solution(new int[]{2, 4, 2, 6, 7, 1}, new int[0], 2);
//        System.out.println(solution);
        AtomicInteger integer = new AtomicInteger(1);
        boolean b = integer.compareAndSet(1, 2);
        System.out.println(integer);
    }
}
