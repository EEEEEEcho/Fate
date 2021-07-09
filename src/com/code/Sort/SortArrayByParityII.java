package com.code.Sort;

import java.util.Arrays;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        int odd[] = new int[A.length / 2];
        int even[] = new int[A.length / 2];

        int m = 0;
        int n = 0;
        for(int i=0;i < A.length;i ++){
            if(A[i] % 2 != 0){
                odd[m ++] = A[i];
            }
            else{
                even[n ++] = A[i];
            }
        }
        m = 0;
        n = 0;
        for(int i = 0;i < A.length;i ++){
            if(i % 2 != 0){
                A[i] = odd[m ++];
            }
            else{
                A[i] = even[n ++];
            }
        }
        return A;
    }
}
