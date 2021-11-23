package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    //前序 + 中序 构造
    public TreeNode build(int[] preorder, int start, int end,
                          int[] inorder, int born, int dead) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[start];
        int index = 0;
        for (int i = born; i <= dead; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //左子树的大小
        int leftSize = index - born;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, start + 1, start + leftSize,
                inorder, born, index - 1);
        root.right = build(preorder, start + leftSize + 1, end,
                inorder, index + 1, dead);
        return root;
    }

    //后序 + 中序 构造
    public TreeNode build2(int[] postorder, int start, int end,
                           int[] inorder, int born, int dead) {
        if (born > dead) return null;
        int rootVal = postorder[end];
        int index = 0;
        for (int i = born; i <= dead; i++) {
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        //左子树的大小
        int leftSize = index - born;
        TreeNode root = new TreeNode(rootVal);
        root.left = build2(postorder,start,start + leftSize - 1,
                inorder,born,index - 1);
        root.right = build2(postorder,start + leftSize,end - 1,
                inorder,index + 1,dead);
        return root;
    }
}
