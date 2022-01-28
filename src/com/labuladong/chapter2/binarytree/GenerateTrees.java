package com.labuladong.chapter2.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1,n);
    }
    public List<TreeNode> build(int low,int high){
        List<TreeNode> ans = new LinkedList<>();
        if (low > high){
            ans.add(null);
            return ans;
        }
        //穷举root节点的所有可能
        for (int i = low;i <= high;i ++){
            //递归构造出左右子树所有合法的BST
            List<TreeNode> leftNodes = build(low,i - 1);
            List<TreeNode> rightNodes = build(i + 1,high);
            //给root节点穷举所有左右子树的组合
            for (TreeNode left : leftNodes){
                for (TreeNode right : rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
