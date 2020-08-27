package com.theswordreferstooffer.offer;

import java.util.Arrays;

public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        Arrays.sort(numbers);
        int countNotCon = 0;
        int zeroCount = 0;
        for(int i=0;i < numbers.length - 1;i ++){
            //王的数量
            if(numbers[i] == 0){
                zeroCount ++;
                continue;
            }
            //不连续的数量
            if(numbers[i + 1] - numbers[i] != 1){
                if(numbers[i + 1] - numbers[i] == 0){
                    return false;
                }
                if(numbers[i + 1] - numbers[i] > 1){
                    countNotCon += numbers[i + 1] - numbers[i];
                }
            }
        }
        //四张王  一张牌的情况
        if(zeroCount == numbers.length - 1){
            return true;
        }
        //不连续的数量可以用王补
        if(countNotCon == zeroCount){
            return true;
        }
        return false;
    }
}
