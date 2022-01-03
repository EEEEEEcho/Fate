package com.labuladong.chapter2.binarytree;

public class BuildTreeByPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length - 1,
                inorder,0,inorder.length - 1);
    }
    public TreeNode build(int[] preor,int pStart,int pEnd,
                          int[] inor,int iStart,int iEnd){
        if (iStart > iEnd) return null;
        int rootValue = preor[pStart];
        TreeNode root = new TreeNode(rootValue);
        int index = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (inor[i] == rootValue){
                index = i;
            }
        }
        root.left = build(preor,pStart + 1,pStart + index - iStart,
                inor,iStart,index - 1);
        root.right = build(preor,pStart + index - iStart + 1,pEnd,
                inor,index + 1,iEnd);
        return root;
    }
}
