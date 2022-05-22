package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;

public class GetMinimumDifference {
    int minResult = Integer.MAX_VALUE;
    TreeNode pre = null;

    /**
     * 二叉搜索树，首选中序遍历，然后用这种有一个前置节点的方法
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        calculate(root);
        return minResult;
    }
    public void calculate(TreeNode node){
        if (node == null) return;
        calculate(node.left);
        if (pre != null){
            minResult = Math.min(minResult,Math.abs(pre.val - node.val));
        }
        pre = node;
        calculate(node.right);
    }
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) return 0;
        int minResult = Integer.MAX_VALUE;
        TreeNode pre = null;
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if (pre != null){
                    minResult = Math.min(minResult,cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return minResult;
    }
}
