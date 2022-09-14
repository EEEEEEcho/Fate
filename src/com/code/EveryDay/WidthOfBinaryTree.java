package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Pair> list = new LinkedList<>();
        list.add(new Pair(root,1));
        int ans = 1;
        while (!list.isEmpty()){
            List<Pair> tmp = new LinkedList<>();
            for(Pair pair : list){
                TreeNode node = pair.node;
                if (node.left != null){
                    tmp.add(new Pair(node.left,pair.index * 2));
                }
                if (node.right != null){
                    tmp.add(new Pair(node.right,pair.index * 2 + 1));
                }
            }
            ans = Math.max(ans,list.get(list.size() - 1).index - list.get(0).index + 1);
            list = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        int i = widthOfBinaryTree.widthOfBinaryTree(treeNode);
    }
}
class Pair{
    TreeNode node;
    Integer index;
    public Pair(TreeNode node,Integer index){
        this.node = node;
        this.index = index;
    }
}
