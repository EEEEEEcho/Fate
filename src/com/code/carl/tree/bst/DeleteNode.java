package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            if (root.left == null && root.right == null){
                return null;
            }
            else if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            else {
                //要删除的包含两个节点
                //从其右子树中获得最小的节点代替当前节点
                TreeNode min = getMin(root.right);
                root.val = min.val;
                //删掉右侧最小的节点
                root.right = deleteNode(root.right,min.val);
            }
        }
        else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
