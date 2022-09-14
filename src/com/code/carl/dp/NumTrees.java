package com.code.carl.dp;

public class NumTrees {
    public int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        //dp[i]表示由i个节点组成的，且节点值从1到n互不相同的二叉搜索树的数量
        //牢记dp数组的含义啊，dp数组代表i个节点存在二叉排序树的个数啊
        int[] dp = new int[n + 1];
        //递推公式
        //结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
        //当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
        //同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
        //所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
        dp[0] = 1;      //0个节点的二叉排序树的个数是1个。。。
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
