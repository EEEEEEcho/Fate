package com.labuladong.chapter2.binarytree;

public class BuildTreeByInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length - 1,
                postorder,0,postorder.length - 1);
    }
    public TreeNode build(int[] inorder,int iLeft,int iRight,
                          int[] postorder,int pLeft,int pRight){
        if (iLeft > iRight) return null;
        int rootValue = postorder[pRight];
        TreeNode treeNode = new TreeNode(rootValue);
        int index = -1;
        for (int i = iLeft; i <= iRight ; i++) {
            if (inorder[i] == rootValue){
                index = i;
            }
        }
        treeNode.right = build(inorder,index + 1,iRight,
                postorder,pRight - (iRight - index),pRight - 1);
        treeNode.left = build(inorder,iLeft,index - 1,
                postorder,pLeft,pLeft + (index - iLeft - 1));
        return treeNode;
    }
}
