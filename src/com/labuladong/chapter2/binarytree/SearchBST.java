package com.labuladong.chapter2.binarytree;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val){
            return root;
        }
        else if(root.val < val){
            root = searchBST(root.right,val);
        }
        else{
            root = searchBST(root.left,val);
        }
        return root;
    }
}
