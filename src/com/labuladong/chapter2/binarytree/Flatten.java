package com.labuladong.chapter2.binarytree;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        //拉平左边
        flatten(root.left);
        //拉平右边
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }

}
