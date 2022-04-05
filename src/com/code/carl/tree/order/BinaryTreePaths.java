package com.code.carl.tree.order;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        preOrder(root,new ArrayList<>());
        return result;
    }
    public void preOrder(TreeNode node, ArrayList<Integer> path){
        path.add(node.val);
        //叶子节点，处理结果并返回  根
        if (node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        //左节点
        if (node.left != null){
            preOrder(node.left,path);
            path.remove(path.size() - 1);   //回溯
        }
        if (node.right != null){
            preOrder(node.right,path);
            path.remove(path.size() - 1);   //回溯
        }
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        ArrayDeque<TreeNode> pathNode = new ArrayDeque<>();
        ArrayDeque<String> pathStr = new ArrayDeque<>();
        pathNode.push(root);
        pathStr.push(String.valueOf(root.val));
        //前序，非递归，遍历顺序，根右左
        while (!pathNode.isEmpty()){
            TreeNode node = pathNode.pop();
            String path = pathStr.pop();
            if (node.left == null && node.right == null){
                //完成了一条路径的遍历
                list.add(path);
            }
            if (node.right != null){
                pathNode.push(node.right);
                pathStr.push(path + "->" + node.right.val);
            }
            if (node.left != null){
                pathNode.push(node.left);
                pathStr.push(path + "->" + node.left.val);
            }
        }
        return list;
    }
}
