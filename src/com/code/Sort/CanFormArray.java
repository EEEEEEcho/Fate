package com.code.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> hashMap = new HashMap<>();
        for(int i = 0;i < pieces.length;i ++){
            hashMap.put(pieces[i][0],pieces[i]);
        }
        for(int i = 0;i < arr.length;){
            int curValue = arr[i];
            if(hashMap.containsKey(curValue)){
                System.out.println(Arrays.toString(hashMap.get(curValue)));
                for(int integer : hashMap.get(curValue)){
                    if(integer == arr[i]){
                        i ++;
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray c = new CanFormArray();
        boolean result = c.canFormArray(new int[]{12,21,11,22},new int[][]{{12,21},{1,2}});
        System.out.println(result);
    }
}
