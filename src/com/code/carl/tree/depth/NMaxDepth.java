package com.code.carl.tree.depth;

import com.code.carl.tree.Node;

public class NMaxDepth {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)),max);
        }
        return max + 1;
    }
}
