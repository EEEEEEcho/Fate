package com.code.carl.tree.count;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumOfLeftLeaves {
    //不能使用层级遍历，因为不好判断左子树
    //采用后续遍历
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumOfLeftLeaves(root.left);   //左
        int rightSum = sumOfLeftLeaves(root.right); //右
        int midSum = 0;
        //这样的是左节点,左边不为空，左边的左边和左边的右边都为空
        if (root.left != null && root.left.left == null && root.left.right == null){
            midSum += root.left.val;
        }
        return leftSum + rightSum + midSum;
    }

    //中序，也可以，只要正确处理根节点
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumOfLeftLeaves1(root.left);
        int mid = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }
        int rightSum = sumOfLeftLeaves1(root.right);
        return leftSum + mid + rightSum;
    }

    //迭代遍历,前序
    public int sumOfLeftLeaves2(TreeNode root){
        if (root == null) return 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null){
                res += node.left.val;
            }
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

}
