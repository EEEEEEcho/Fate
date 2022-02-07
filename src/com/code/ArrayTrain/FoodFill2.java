package com.code.ArrayTrain;

import java.util.Arrays;

public class FoodFill2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return null;
    }
    public int[] test(int[] arr,int index){
        if (index == arr.length){
            return arr;
        }
        else{
            arr[index] = 1;
            return test(arr,index + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        FoodFill2 f = new FoodFill2();
        f.test(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
