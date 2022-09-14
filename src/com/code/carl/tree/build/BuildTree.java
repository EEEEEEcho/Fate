package com.code.carl.tree.build;

import com.code.carl.tree.TreeNode;

public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildInAndPost(inorder,0,inorder.length - 1,
                postorder,0,postorder.length - 1);
    }
    public TreeNode buildInAndPost(int[] inorder,int iLeft,int iRight,
                                   int[] postorder,int pLeft,int pRight){
        if (iLeft > iRight) return null;
        int rootValue = postorder[pRight];
        TreeNode root = new TreeNode(rootValue);
        int index = -1;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        root.right = buildInAndPost(inorder,index + 1,iRight,
                postorder,pRight - (iRight - index),pRight - 1);
        root.left = buildInAndPost(inorder,iLeft,index - 1,
                postorder,pLeft,pLeft + (index - iLeft - 1));
        return root;
    }

    public TreeNode buildInAndPre(int[] inorder,int iLeft,int iRight,
                                   int[] preorder,int pLeft,int pRight){
        if (iLeft > iRight) return null;
        int value = preorder[pLeft];
        TreeNode root = new TreeNode(value);
        int index = -1;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == value){
                index = i;
                break;
            }
        }
        root.right = buildInAndPre(inorder,index + 1,iRight,
                preorder,pLeft + (index - iLeft) + 1,pRight);
        root.left = buildInAndPre(inorder,iLeft,index - 1,
                preorder,pLeft + 1,pLeft + (index - iLeft));
        return root;
    }

}
