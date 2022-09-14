package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val > root.val) return searchBST(root.right,val);
        return searchBST(root.left,val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null){
            if (val == root.val){
                return root;
            }
            else if(val > root.val){
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return null;
    }
}
