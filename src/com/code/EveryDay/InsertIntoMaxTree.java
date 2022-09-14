package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InsertIntoMaxTree {
    private List<Integer> list = new ArrayList<>();
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        midOrder(root);
        list.add(val);
        return buildTree(list,0,list.size() - 1);
    }

    public void midOrder(TreeNode root){
        if (root == null) return;
        midOrder(root.left);
        list.add(root.val);
        midOrder(root.right);
    }

    public TreeNode buildTree(List<Integer> list,int left,int right){
        if (left > right) return null;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (list.get(i) > max){
                max = list.get(i);
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildTree(list,left,index - 1);
        node.right = buildTree(list,index + 1,right);
        return node;
    }
}
