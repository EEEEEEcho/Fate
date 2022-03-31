package com.code.carl.tree.levelorder;

import com.code.carl.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> children = node.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
