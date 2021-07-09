package com.code.GreedyTrain;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        for(int i = 0;i < A.length;i ++){
            if(A[i] < 0 && K > 0){
                A[i] = -A[i];
                K --;
            }
            else {
                break;
            }
        }
        System.out.println(Arrays.toString(A));
        if(K > 0){
            Arrays.sort(A);
            if(K % 2 != 0){
                A[0] = -A[0];
            }
        }
        System.out.println(Arrays.toString(A));
        int sum = 0;
        for(int i=0;i < A.length;i ++){
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations l = new LargestSumAfterKNegations();
        System.out.println(l.largestSumAfterKNegations(new int[]{-2,5,0,2,-2},3));
    }
}
