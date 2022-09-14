package com.interview.ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Four {
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int length = A.length;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (A[i] != B[i]){
                int tmpMin = Math.min(A[i],B[i]);
                int tmpMax = Math.max(A[i],B[i]);
                if (!set.contains(tmpMin)){
                    set.add(tmpMax);
                    A[i] = tmpMax;
                    min = Math.min(min,tmpMin);
                }
                else {
                    if (!set.contains(tmpMax)){
                        min = Math.min(min,tmpMin);
                    }
                    A[i] = tmpMin;
                }
            }
            else {
                set.add(A[i]);
            }
        }
        return min;
    }
}
