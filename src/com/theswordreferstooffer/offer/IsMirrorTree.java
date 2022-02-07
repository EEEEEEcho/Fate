package com.theswordreferstooffer.offer;

public class IsMirrorTree {
    /**
     * 利用递归进行判断，若左子树的左孩子等于右子树的右孩子且左子树的右孩子等于右子树的左孩子，
     * 并且左右子树节点的值相等，则是对称的
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return pRoot == null || isCommon(pRoot.left,pRoot.right);
    }
    public boolean isCommon(TreeNode left,TreeNode right){
        //一定要先且判断 再或判断。， 否则后面或判断中也包含二者都为空的情况
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && isCommon(left.left,right.right) && isCommon(left.right,right.left);
    }
}
