package com.leetCode.TreeTrain;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val != subRoot.val) {
            return isSubtree(root, subRoot);
        }
        return true;
    }
}
