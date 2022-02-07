package com.code.TreeTrain;

import java.util.LinkedList;
import java.util.Queue;

public class NTreeMaxDepth {
    public int maxDepth(Node root) {
        /**
         * 层次遍历
         */
        if(root == null){
            return 0;
        }
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()){
            //队列当前的大小，就是当前一层中所含节点的数量！！！！！！！
            int size = queue.size();
            while (size > 0){
                Node node = queue.poll();
                if(node != null){
                    for (Node child : node.children){
                        queue.offer(child);
                    }
                }
                size --;
            }
            level ++;
        }
        return level;
    }

    public int maxDepth2(Node root) {
        /**
         * 深度优先遍历
         */
        if(root == null){
            return 0;
        }
        int result = 1;
        for(Node child : root.children){
            result = Math.max(result,maxDepth2(child) + 1);
        }
        return result;
    }
}
