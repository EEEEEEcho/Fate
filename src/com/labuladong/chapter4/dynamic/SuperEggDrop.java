package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class SuperEggDrop {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(memo[i], - 1);
        }
        dp(k,n);
        return memo[k][n];
    }

    /**
     * 状态：当前拥有的鸡蛋数量和需要测试的楼层数量
     * 选择：去哪个楼层扔鸡蛋
     * dp[k][n]代表，当前拥有k个鸡蛋需要测试的楼层有n层
     * @param k
     * @param n
     * @return
     */
    public int dp(int k,int n){
        //如果只有一个鸡蛋，肯定需要测试n次
        if(k == 1) return n;
        //如果楼层为 0 肯定不需要测试
        if (n == 0) return 0;
        if (memo[k][n] != -1) return memo[k][n];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,
                    Math.max(
                            dp(k,n - k),        //在这层没有碎，测试从这层的上层开始到顶层的楼层
                            dp(k - 1,i - 1)     //在这层碎了，测试从这层的下层开始到底层
                    ) + 1
            );
        }
        memo[k][n] = res;
        return memo[k][n];
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (nums[left] != val ){
                left ++;
            }
            while (nums[right] == val){
                right --;
            }
            if (left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SuperEggDrop s = new SuperEggDrop();
        int i = s.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }
}
