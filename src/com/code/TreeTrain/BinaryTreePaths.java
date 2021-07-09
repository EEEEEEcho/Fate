package com.code.TreeTrain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(root.val + "");
        while (!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.poll();
            String path = pathQueue.poll();
            if (temp.left == null && temp.right == null){
                result.add(path);
            }
            else{
                if (temp.left != null){
                    nodeQueue.offer(temp.left);
                    pathQueue.offer(path + "->" + temp.left.val);
                }
                if(temp.right != null){
                    nodeQueue.offer(temp.right);
                    pathQueue.offer(path + "->" + temp.right.val);
                }
            }
        }
        return result;
    }
}
