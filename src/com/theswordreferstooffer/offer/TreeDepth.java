package com.theswordreferstooffer.offer;

public class TreeDepth {
    public int deepth = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeDepth t = new TreeDepth();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int res = t.TreeDepth(root);
        System.out.println(res);
    }
}
