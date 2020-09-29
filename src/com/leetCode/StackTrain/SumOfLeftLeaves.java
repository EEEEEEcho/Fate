package com.leetCode.StackTrain;

public class SumOfLeftLeaves {
    /*
    * 计算给定二叉树的所有左叶子之和。
    *   3
       / \
      9  20
        /  \
       15   7

    在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
    * 解决办法:深搜
    * */
    public int sumOfLeftLeaves(TreeNode root) {
       return dfs(root,0,false);
    }
    private int dfs(TreeNode root,int sum,boolean isLeft){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null && isLeft){
            return root.val;
        }
        return dfs(root.left,sum,true) + dfs(root.right,sum,false);
    }

    public static void main(String[] args) {

    }
}
