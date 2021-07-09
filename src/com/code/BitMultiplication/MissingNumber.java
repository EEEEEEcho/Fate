package com.code.BitMultiplication;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        System.out.println(n);
        int sum = n * (n - 1) / 2;
        System.out.println(sum);
        for(int i=0;i < nums.length;i ++){
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int result = m.missingNumber(new int[]{3,0,1});
        System.out.println(result);
    }
}