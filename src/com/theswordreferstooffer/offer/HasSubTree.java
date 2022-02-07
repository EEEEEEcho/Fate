package com.theswordreferstooffer.offer;

/**
 * ：输入两棵二叉树 A，B，判断 B 是不是 A 的子结构。
 * （ps：我们约定空 树不是任意一个树的子结构）
 */
public class HasSubTree {
    /**
     * 若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则
     * 利用递归分别在左右子树中查找。
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return false;
        }
        if(root1 == null){
            return false;
        }
        return isSubTree(root1,root2) || isSubTree(root1.left,root2) || isSubTree(root1.right,root2);
    }

    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        }
        return false;
    }
}
