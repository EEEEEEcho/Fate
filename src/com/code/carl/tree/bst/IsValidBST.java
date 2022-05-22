package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsValidBST {
    /**
     * 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
     * 要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。
     * @param root
     * @return
     */
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        inOrder(root);
        int tmp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (tmp >= list.get(i)){
                return false;
            }
            tmp = list.get(i);
        }
        return true;
    }
    private void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    /**
     * 递归方法，记录一下中序遍历时的前一个结点。
     * 如果前一个结点的值大于了当前节点的值，那么就证明该二叉搜索树的中序是非递增的
     * 二叉搜索树中不允许出现等于的情况
     * @param root
     * @return
     */
    TreeNode pre = null;
    public boolean isValidBST2(TreeNode root){
        if (root == null) return true;
        boolean left = isValidBST2(root.left);
        if (pre != null && root.val <= pre.val){
            return false;
        }
        pre = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root){
        if (root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
