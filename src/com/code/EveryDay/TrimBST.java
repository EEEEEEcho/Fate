package com.code.EveryDay;

import com.code.StackTrain.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low){
            //在右边
            TreeNode right = trimBST(root.right,low,high);
            return right;
        }
        if (root.val > high){
            //在左边
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
