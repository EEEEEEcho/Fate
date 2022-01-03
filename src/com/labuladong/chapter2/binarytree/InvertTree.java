package com.labuladong.chapter2.binarytree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//        TreeNode temp = invertTree(root.left);
//        root.left = invertTree(root.right);
//        root.right = temp;
//        return root;
        //前序遍历
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

}
