package com.code.carl.tree.pathsum;

import com.code.carl.tree.TreeNode;

public class HasPathSum {
    /**
     * 本题目必须是要遍历到叶子节点的路径。
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root,targetSum - root.val);
    }

    public boolean traversal(TreeNode node,int count){
        //如果达到了叶子节点且满足目标结果 返回true
        if (node.left == null && node.right == null && count == 0) return true;
        //如果达到了叶子节点，不满足目标结果，返回false
        if (node.left == null && node.right == null) return false;
        //左子树
        if (node.left != null){
            count -= node.left.val;
            if (traversal(node.left,count)) return true;
            count += node.left.val;
        }
        if (node.right != null){
            count -= node.right.val;
            if (traversal(node.right,count)) return true;
            count += node.right.val;
        }
        return false;
    }
}
