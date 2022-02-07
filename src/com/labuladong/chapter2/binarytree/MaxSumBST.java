package com.labuladong.chapter2.binarytree;

import java.util.TreeSet;

public class MaxSumBST {
    private int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    //// 函数返回 int[]{ isBST, min, max, sum}
    //res[0] 记录以 root 为根的⼆叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
    //res[1] 记录以 root 为根的⼆叉树所有节点中的最⼩值；
    //res[2] 记录以 root 为根的⼆叉树所有节点中的最⼤值；
    //res[3] 记录以 root 为根的⼆叉树所有节点值之和
    public int[] traverse(TreeNode root){
        if (root == null){
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        //递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        //后序遍历
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            //以root为根的二叉树是BST
            res[0] = 1;
            //计算以root为根的这颗BST的最小值
            res[1] = Math.min(left[1], root.val);
            //计算以root为根的这颗BST的最大值
            res[2] = Math.max(right[2], root.val);
            //计算以root为根的这颗BST的所有节点之和
            res[3] = left[3] + right[3] + root.val;
            //更新全局变量
            maxSum = Math.max(maxSum,res[3]);
        }
        else {
            //否则，以root为根的二叉树不是BST
            res[0] = 0;
            //其他值没必要计算
        }
        return res;
    }
}
