package com.code.TreeTrain;

import java.util.*;

public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int nextCount = 1;  //记录是否遍历完一层
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(root.val, root.val);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count ++;
            if(node.left != null){

                hashMap.put(node.left.val,node.val);
                queue.offer(node.left);
            }
            if (node.right != null){
                hashMap.put(node.right.val,node.val);
                queue.offer(node.right);
            }
            if(count == nextCount){
                //遍历完了一层之后，在该层中找有没有堂兄弟
                nextCount = queue.size();
                count = 0;
                Integer xPre = hashMap.get(x);
                Integer yPre = hashMap.get(y);
                if (xPre != null && !xPre.equals(yPre)){
                    return true;
                }
                hashMap.clear();
            }
        }
        return false;
    }
}
