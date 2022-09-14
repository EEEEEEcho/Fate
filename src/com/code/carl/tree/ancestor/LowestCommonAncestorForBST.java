package com.code.carl.tree.ancestor;

import com.code.carl.tree.TreeNode;

public class LowestCommonAncestorForBST {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    //因为是二叉搜索树，所以两个节点的公共祖先已经是比两个节点中的一个大，比另一个小
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);
    }

    public TreeNode traversal(TreeNode cur,TreeNode p,TreeNode q){
        if (cur == null) return null;
        if (cur.val < p.val && cur.val < q.val) {
            //比二者都小，那么就证明答案在右边,因为右边的是大的
            TreeNode left = lowestCommonAncestor(cur.right, p, q);
            if (left != null) {
                return left;
            }
        }
        if (cur.val > p.val && cur.val > q.val) {
            //比二者都大，那么证明答案在左边，因为左边的是小的
            TreeNode right = lowestCommonAncestor(cur.left, p, q);
            if (right != null) {
                return right;
            }
        }
        return cur;
    }
    //迭代法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
