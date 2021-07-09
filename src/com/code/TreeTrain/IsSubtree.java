package com.code.TreeTrain;

public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subTree(root,subRoot);
    }
    /**
     * 判断一个树是否为另一个树的子树的三个条件是或的关系：
     * 1.当前两个树相等
     * 2.或树是另一个树的左子树
     * 3.或树是另一个树的右子树
     * @param root
     * @param subRoot
     * @return
     */
    public boolean subTree(TreeNode root,TreeNode subRoot){
        if(root == null){
            return false;
        }
        return isSame(root,subRoot) || subTree(root.left,subRoot) || subTree(root.right,subRoot);
    }
    /**
     * 将是否子树问题转换为是否相等问题，
     * 判断两个树是否相等的条件：
     * 1.两个树的根节点相等
     * 2.两个树的左子树相等
     * 3.两个树的右子树相等
     * @param node1
     * @param node2
     * @return
     */
    public boolean isSame(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return isSame(node1.left,node2.left) && isSame(node1.right,node2.right);
    }
}
