package com.code.carl.tree.check;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left,root.right);
    }
    public boolean judge(TreeNode node1,TreeNode node2){
        //先判断两个结点的情况
        if (node1 == null && node2 == null){
            return true;
        }
        else if(node1 != null && node2 == null){
            return false;
        }
        else if(node1 == null && node2 != null){
            return false;
        }
        else if(node1 != null && node2 != null && node1.val != node2.val){
            return false;
        }
        //结点判断完了，判断两个结点的左右子树的情况
        //判断左子树的左边和右子树的右边是否相同
        boolean left = judge(node1.left,node2.right);
        //判断左子树的右边和右子树的左边是否相同
        boolean right = judge(node1.right,node2.left);
        return left && right;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        //使用队列判断
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //如果二者都为空，则是对称的
            if (left == null && right == null) continue;

            if (left == null || right == null || left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
