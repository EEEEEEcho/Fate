package com.theswordreferstooffer.offer;

public class MirrorTree {
    /**
     * 使用递归或非递归方式交换每个节点的左右子树位置
     * @param root
     */
    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }

}
