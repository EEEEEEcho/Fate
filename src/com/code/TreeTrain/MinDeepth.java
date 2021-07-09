package com.code.TreeTrain;

public class MinDeepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        //求左边的最小深度
        if(root.left != null){
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        //求右边的最小深度
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right),minDepth);
        }
        return minDepth + 1;
    }
}
