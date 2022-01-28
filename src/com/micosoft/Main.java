package com.micosoft;

import java.util.Arrays;

public class Main {
    public int solution(int N, int[] A, String S) {
        // write your code in Java SE 8
        int[] array = new int[N * N];
        for (int i = 0; i < A.length; i++) {
            char c = S.charAt(i);
            int n = A[i];
            if (c == 'R'){
                for (int j = 0; j < N; j++) {
                    array[n * N + j] ++;
                }
            }
            else if(c == 'C'){
                for (int j = 0; j < N; j++) {
                    array[j * N + n] ++;
                }
            }
        }
        return Arrays.stream(array).max().getAsInt();
    }
}
