package com.code.ArrayTrain;

import java.util.Arrays;

public class ArrayPairSum {
    /**
     * 一句话，我们每次选择都想选个大的，但是最大的不能选（因为 min），所以每次选第二大的。
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0;i < nums.length;i += 2){
            result += i;
        }
        return result;
    }
}
