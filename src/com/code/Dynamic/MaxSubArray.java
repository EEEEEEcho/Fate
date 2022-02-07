package com.code.Dynamic;

public class MaxSubArray {
    //[-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //nums[i] 加上原来的最大和 pre 如果比当前的nums[i]大，那么就更新pre为 pre + nums[i]
            //如果nums[i] 加上 pre 变小了。那还不如不要pre，让nums[i]变成pre
            pre = Math.max(pre + nums[i],nums[i]);
            res = Math.max(res,pre);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray subArray = new MaxSubArray();
        subArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
