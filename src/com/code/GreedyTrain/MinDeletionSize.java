package com.code.GreedyTrain;

public class MinDeletionSize {
    public int minDeletionSize(String[] A) {
        if(A.length == 0){
            return 0;
        }
        int result = 0;
        int j = A[0].length();
        for(int k = 0;k < j;k ++){
            for(int i = 0;i < A.length - 1;i ++){
                //System.out.println(A[i].charAt(k) + " : " + A[i + 1].charAt(k));
                if(A[i].charAt(k) > A[i + 1].charAt(k)){
                    result ++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinDeletionSize minDeletionSize = new MinDeletionSize();
        System.out.println(minDeletionSize.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
