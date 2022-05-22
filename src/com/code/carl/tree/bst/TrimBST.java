package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //先把要删除的节点找出来，标记
        if (root == null) return null;
        if (root.val < low){
            //当前值没有在[low,high]的范围内。比low小，向右找
            TreeNode right = trimBST(root.right,low,high);
            return right;
        }
        if (root.val > high){
            //同理左边
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        // root->left接住符合条件的左孩子
        root.left = trimBST(root.left,low,high);
        // root->right接住符合条件的右孩子
        root.right = trimBST(root.right,low,high);
        return root;
    }

}
