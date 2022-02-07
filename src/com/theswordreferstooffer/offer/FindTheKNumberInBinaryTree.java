package com.theswordreferstooffer.offer;

import java.util.ArrayList;

public class FindTheKNumberInBinaryTree {
    //空间换时间的方法
//    ArrayList<TreeNode> list = new ArrayList();
//    TreeNode KthNode(TreeNode pRoot, int k) {
//        if(pRoot == null){
//            return null;
//        }
//        orderTrivaleTree(pRoot);
//        if(k > list.size() || k <=0 ){
//            return null;
//        }
//        return list.get(k-1);
//    }
//    void orderTrivaleTree(TreeNode pRoot){
//        if(pRoot == null){
//            return;
//        }
//        orderTrivaleTree(pRoot.left);
//        list.add(pRoot);
//        orderTrivaleTree(pRoot.right);
//    }
    //书中解法

    /**
     * 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序，
     * 第 k 个 结点就是第 K 大的节点，分别递归查找左右子树的第 K 个节点，
     * 或使用非递归借用栈的方式查找，当 count=k 时返回根节点
     * @param pRoot
     * @param k
     * @return
     */
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return null;
        }
        //左
        TreeNode node = KthNode(pRoot.left,k);
        if(node != null){
            return node;
        }
        //根
        count ++;
        if(count == k){
            return pRoot;
        }
        //右
        node = KthNode(pRoot.right,k);
        return node;
    }
}
