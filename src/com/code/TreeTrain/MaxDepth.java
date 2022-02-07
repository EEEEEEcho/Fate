package com.code.TreeTrain;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root == null){
//            return 0;
//        }
//        queue.add(root);
//        int i = 0;
//        while (!queue.isEmpty()){
//            i ++;
//            TreeNode node = queue.poll();
//            if(node.left != null){
//                queue.add(node.left);
//            }
//            if(node.right != null){
//                queue.add(node.right);
//            }
//        }
//        return i;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left) + 1,maxDepth(root.right) + 1);
    }
}
