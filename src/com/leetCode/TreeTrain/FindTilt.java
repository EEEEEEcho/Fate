package com.leetCode.TreeTrain;

public class FindTilt {
    int titl = 0;   //坡度和
    public int findTilt(TreeNode root) {
        dps(root);
        return titl;
    }

    public int dps(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = dps(node.left);
        int right = dps(node.right);
        titl += Math.abs(left - right);
        return left + right + node.val;
    }
}
