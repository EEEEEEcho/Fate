package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

public class Flatten {
    //遍历的顺序为先序，但是，拉平的顺序为后序
    public void flatten(TreeNode root) {
        //怎么说呢，就很迷的操作
        if (root == null) return;
        //先拉平左子树
        flatten(root.left);
        //再拉平右子树
        flatten(root.right);

        //拉平之后，将左子树放到右子树的位置
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        //然后将右子树移植过去
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }

    //另一种清奇的解法
    public void flatten2(TreeNode root){
        while (root != null){
            if (root.left == null){
                //左子树为null直接考虑下一个节点
                root = root.right;
            }
            else{
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                //将原来的右子树，接到左子树的最右节点下面
                pre.right = root.right;
                //将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                //下一个节点
                root = root.right;
            }
        }
    }
}
