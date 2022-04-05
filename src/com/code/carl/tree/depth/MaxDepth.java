package com.code.carl.tree.depth;

import com.code.carl.tree.TreeNode;

public class MaxDepth {
    //后序遍历
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //左
        int left = maxDepth(root.left);
        //右
        int right = maxDepth(root.right);
        //根
        return Math.max(left,right) + 1;
    }
    //前序遍历
    int result = 0;
    public void getDepth(TreeNode root,int depth){
        //首先更新结果
        result = Math.max(result,depth);
        //判断root的情况
        if (root == null) return;
        //判断左边
        if (root.left != null){
            getDepth(root.left,depth + 1);
        }
        //判断右边
        if (root.right != null){
            getDepth(root.right,depth + 1);
        }
        return;
    }
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        getDepth(root,1);
        return result;
    }
}
