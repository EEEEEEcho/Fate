package com.code.ArrayTrain;

public class MaxSubArray {
    /**
     * 动态规划，无空间优化版
     * 大家发现了吗，如果编号为 i 的子问题的结果是负数或者 00 ，那么编号为 i + 1 的子问题就可以把编号为 i 的子问题的结果舍弃掉（这里 i 为整数，最小值为 1 ，最大值为 8），这是因为：
     *
     * 一个数 a 加上负数的结果比 a 更小；
     * 一个数 a 加上 00 的结果不会比 a 更大；
     * 而子问题的定义必须以一个数结尾，因此如果子问题 i 的结果是负数或者 00，那么子问题 i + 1 的答案就是以 nums[i] 结尾的那个数。
     * 因为我们把子问题定义的更清楚，子问题之间的联系就容易观察到。这是我们定义子问题、定义状态的经验。
     * 详细解释：
     * https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     * 这道题的核心概念在于以当前元素作为标准，当前元素作为子序列的结尾
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }
            else{
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int re : dp){
            res = Math.max(re,res);
        }
        return res;
    }

    /**
     * 优化空间版
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums){
        int pre = 0;
        int res = nums[0];
        for (int num : nums){
            //加上当前数值之后如果变得比当前数值更大，那么就证明pre是大于0的，
            //否则就证明pre是小于0的，从当前数值重新开始
            pre = Math.max(pre + num,num);
            res = Math.max(res,pre);
        }
        return res;
    }
}
