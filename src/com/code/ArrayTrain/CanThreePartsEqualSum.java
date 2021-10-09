package com.code.ArrayTrain;

import java.util.Arrays;

public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 3 != 0){
            return false;
        }
        int target = sum / 3;
        int i = 0;
        int current = 0;
        while (i < arr.length){
            current += arr[i];
            if (current == target){
                break;  //找到了第一组值
            }
            i++;
        }
        int j = i + 1;
        while (j < arr.length){
            current += arr[j];
            if (current == target * 2 && j != arr.length - 1){
                //如果找到了第二组，而且j也没有到达最后一个，那么就证明成功
                return true;
            }
            j ++;
        }
        return false;
    }

    public static void main(String[] args) {
        CanThreePartsEqualSum c = new CanThreePartsEqualSum();
        int[] arr = new int[]{0,2,1,-6,6,7,9,-1,2,0,1};
        c.canThreePartsEqualSum(arr);
    }
}
