package com.code.topOnehundred;

import com.code.StackTrain.TreeNode;

public class PathSum {
    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        dfs1(root,targetSum);
        return count;
    }
    //双重dfs,和双层for循环一个道理。从当前节点开始，向后遍历，
    public void dfs1(TreeNode node,int targetSum){
        if (node == null){
            return;
        }
        dfs2(node,targetSum,0);
        dfs1(node.left,targetSum);
        dfs1(node.right,targetSum);
    }
    public void dfs2(TreeNode node,int targetSum,int nowSum){
        if (node == null) return;
        nowSum += node.val;
        if (nowSum == targetSum){
            count ++;
        }
        if (node.left != null) dfs2(node.left,targetSum,nowSum);
        if (node.right != null) dfs2(node.right,targetSum,nowSum);
    }
}
