package com.theswordreferstooffer.offer;

import java.util.Arrays;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.val = val;
    }
}
public class RebuildBinaryTree {
    /**
     * 先找出根节点，然后使用递归的方法建立二叉树，方法一传入数组的拷贝
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        if(pre.length != in.length){
            return null;
        }
        //建立根节点
        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i < in.length;i ++){
            if(pre[0] == in[i]){
                //这里有点不好理解
                //pre : 1 2 4 7 3 5 6 8
                //in :  4 7 2 1 5 3 8 6
                //根节点为1，在中序中，以1为分界 4 7 2为左子树，5 3 8 6为右子树 不好找的点是在先序中找到 左子树终点的坐标。
                //因为在中序中从0 到i-1 为左子树的范围，而在先序中是从1号开始找左子树的，因为0号单元为根，所以当中序中遍历至i找到
                //所有左子树后，前序中的左子树就是从1 到 i + 1
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }

    /**
     * 方法二：传入子数组的边界索引。
     * 思想与传递数组拷贝类似，但是这样更节省空间
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        return helper(pre,0,pre.length - 1,in,0,in.length - 1);
    }
    private TreeNode helper(int pre[],int preL,int preR,int in[],int inL,int inR){
        if(preL > preR || inL > inR){
            return null;
        }
        int rootVal = pre[preL];
        int index = 0;
        while (index < inR && in[index] != rootVal){
            index ++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(pre,preL + 1,preL - inL + index,in,inL,index);
        root.right = helper(pre,preL - inL + index +1,preR,in,index + 1,inR);
        return root;
    }
}
