package com.leetCode.TreeTrain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    List<Double> result = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int count = size;
            double avg = 0;
            while (size > 0){
                TreeNode node = queue.poll();
                if(node != null){
                     avg += node.val;
                     if(node.left != null){
                         queue.offer(node.left);
                     }
                     if(node.right != null){
                         queue.offer(node.right);
                     }
                }
                size --;
            }
            result.add(avg / count);
        }
        return result;
    }
}
