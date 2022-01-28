package com.labuladong.chapter2.binarytree;

public class DeleteNodeFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            //1.要删除的是叶子节点
            if (root.left == null && root.right == null){
                //直接删除
                return null;
            }
            //2.要删除的节点只包含一个子节点，那么直接返回子节点替代删除的节点
            else if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            //3.要删除的节点包含两个子节点
            else{
                //从其右子树中获得最小的节点，替代当前节点
                TreeNode rightMin = getMin(root.right);
                //将当前节点的值与右侧最小节点的值交换
                root.val = rightMin.val;
                //删掉右侧最小节点
                root.right = deleteNode(root.right, rightMin.val);
            }
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else {
            root.left = deleteNode(root.left,key);
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
