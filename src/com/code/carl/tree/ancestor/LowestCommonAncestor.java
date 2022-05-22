package com.code.carl.tree.ancestor;

import com.code.carl.tree.TreeNode;

public class LowestCommonAncestor {
    /**
     * 思路：递归
     * 递归终止条件：当前节点是个叶子节点或者二者的公共祖先就是p或者q
     * 递归：后序遍历，判断左子树中和右子树中是否有公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        else if(left == null){
            return right;
        }
        else {
            return left;
        }
    }
}
