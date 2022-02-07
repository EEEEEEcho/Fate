package com.code.TreeTrain;

public class SumRootToLeaf {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode node,int tmp){
        if (node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += tmp * 2 + node.val;
            return;
        }
        dfs(node.left,tmp * 2 + node.val);
        dfs(node.right,tmp * 2 + node.val);
    }

    public static void main(String[] args) {
        int i = Integer.parseUnsignedInt("10", 2);
        System.out.println(i);
    }
}
