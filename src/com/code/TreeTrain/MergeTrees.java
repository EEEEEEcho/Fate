package com.code.TreeTrain;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //这个递归出口是神作，
        //如果节点一是空的，就返回节点二作为子节点
        //如果节点二是空的，就返回节点一作子节点
        //如果两个节点都是空的，那么返回的必然是节点二，还是空节点
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left,root2.left);
        treeNode.right = mergeTrees(root1.right,root2.right);
        return treeNode;
    }
}
