package com.code.carl.tree.count;

import com.code.carl.tree.TreeNode;

public class CountNodes {
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }

    /**
     * 完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
     * 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
     * 对于情况二，分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算
     * @param root
     * @return
     */
    public int countNodes(TreeNode root){
        if (root == null) return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;
        //左子树高度,只需要找左子树的最左边
        int leftHeight = 0;
        //右子树高度,只需要找右子树的最右边
        int rightHeight = 0;
        TreeNode p = left;
        TreeNode q = right;
        while (p != null){
            leftHeight ++;
            p = p.left;
        }
        while (q != null){
            rightHeight ++;
            q = q.right;
        }
        //如果左子树的最左边和右子树的最右边高度相同，那么就证明这子树是个完全二叉树
        //按照完全二叉树的方式计算
        if (leftHeight == rightHeight){
            return (2 << leftHeight) - 1;
        }
        //否则证明这是个完全二叉树，按照正常方式计算
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
