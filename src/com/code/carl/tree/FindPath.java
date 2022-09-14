package com.code.carl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindPath {
    public static List<String> binaryTreePaths(TreeNode root) {
        // 存放最终的结果，所有从根到叶子的路径
        ArrayList<String> arrayList = new ArrayList<>();
        // 对根节点为空这种特殊情况的处理
        if(root == null){
            return arrayList;
        }
        // 双端队列储存遍历的路径
        Deque<Integer> path = new ArrayDeque<>();
        // 先把根节点存进去
        path.addLast(root.val);
        // 开始递归前序遍历二叉树
        dfs(root,path,arrayList);
        return arrayList;
    }
    public static void dfs(TreeNode node, Deque<Integer> path, ArrayList<String> arrayStr) {
        if(node.left != null) {
            // 左节点不空，路径中添加左节点的值，以左节点为根节点，继续遍历
            path.addLast(node.left.val);
            dfs(node.left,path,arrayStr);
            // 回溯，遍历完左节点，路径中删除左节点的值
            path.removeLast();
        }
        if(node.right != null){
            // 右节点不空，路径中添加右节点的值，以右节点为根节点，继续遍历
            path.addLast(node.right.val);
            dfs(node.right,path,arrayStr);
            // 回溯，遍历完右节点，路径中删除右节点的值
            path.removeLast();
        }
        // 当左右节点都空时，是叶子节点，拼接成题目要求格式的字符串，添加到最终结果中
//        if(node.left == null && node.right == null) {
//            StringBuilder sb = new StringBuilder();
//            for (Integer val : path){
//                sb.append(val).append(" -> ");
//            }
//            sb.replace(sb.la)
//            arrayStr.add(temp);
//        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(node));
    }
}
