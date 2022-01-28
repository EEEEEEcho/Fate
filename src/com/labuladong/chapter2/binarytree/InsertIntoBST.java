package com.labuladong.chapter2.binarytree;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBST i = new InsertIntoBST();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        root.left = left;
        TreeNode treeNode = i.insertIntoBST(root, 5);

    }
}
