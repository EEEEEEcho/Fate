package com.leetCode.TreeTrain;

public class DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        ans = 1;
        depth(root);
        return ans - 1;
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);    //左儿子为根的  左子树的深度
        int right = depth(node.right);  //右儿子为根的  右子树的深度
        ans = Math.max(ans,left + right + 1);
        return Math.max(left,right) + 1;
    }
}
