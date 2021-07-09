package com.code.TreeTrain;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return root;
        }
        if(root.val == val){
            return root;
        }
        TreeNode result;
        if(val < root.val){
            result = searchBST(root.left,val);
        }
        else {
            result = searchBST(root.right,val);
        }
        return result;
    }
    public TreeNode searchBST2(TreeNode root, int val){
        while (root != null && root.val != val){
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }

}
