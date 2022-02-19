package com.labuladong.chapter4.dynamic;

import com.code.TreeTrain.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HouseRobber {
    //198 打家劫舍 普通版
    public int rob(int[] nums) {
        //dp状态的含义表示：dp[i]小偷走到第i间房子的时候，取得的最大收益
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i < dp.length; i++) {
//            //到达第i间房屋的最大收益，等于不选第i间房屋的收益 和 选第i间房屋的收益加上前面房屋收益的和
//            dp[i] = Math.max(dp[i - 1],dp[i - 1] + nums[i - 1]);
//        }
//        return dp[dp.length - 1];
        //状态压缩
        int a = 0;
        int b = nums[0];
        for(int i = 1; i < nums.length;i ++){
            int tmp = b;
            b = Math.max(b,a + nums[i]);
            a = tmp;
        }
        return b;
    }
    //213 打家劫舍2，环形数组问题:
    //分类讨论：
    //抢第一间，不抢最后一间
    //抢最后一间，不抢第一间
    //第一间和最后一间都不抢
    //本题只需判断前两种情况即可
    public int rob2(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            int a = 0;
            int b = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                int tmp = b;
                b = Math.max(b, a + nums[i]);
                a = tmp;
            }

            int c = 0;
            int d = nums[1];
            for (int i = 2; i < nums.length; i++) {
                int tmp = d;
                d = Math.max(d, c + nums[i]);
                c = tmp;
            }
            return Math.max(b,d);
        }
    }

    //337 二叉树形式抢劫
    private HashMap<TreeNode,Integer> memo = new HashMap<>();
    public int rob3(TreeNode root){
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        //就是硬写
        //抢
        int do_it = root.val
                + (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right))
                + (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));
        //不抢
        int not_do = rob3(root.left) + rob3(root.right);
        int res = Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }

    public static void main(String[] args) {
        int count = 0;
        int start = 1;
        while (start <= 5){
            start = start << 1;
            count ++;
        }
        System.out.println(count);

    }
}
