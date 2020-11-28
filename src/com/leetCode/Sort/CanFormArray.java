package com.leetCode.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        if(pieces.length == 1 && pieces[0][0] != arr[0]){
            return false;
        }
        Arrays.sort(pieces, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length){
            for(int j = 0;j < pieces.length;j ++){
                for(Integer integer : pieces[j]){
                    if(integer != arr[i ++]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray c = new CanFormArray();
        c.canFormArray(new int[]{1,2,3},new int[][]{{78},{4,64},{91}});
    }
}
