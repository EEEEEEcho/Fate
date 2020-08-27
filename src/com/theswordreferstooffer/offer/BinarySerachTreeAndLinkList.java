package com.theswordreferstooffer.offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/**
 * 定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
 */
public class BinarySerachTreeAndLinkList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        //链表尾节点
        TreeNode lastlist = convertNode(pRootOfTree,null);
        //头节点
        TreeNode head = lastlist;
        while (head != null && head.left != null){
            head = head.left;
        }
        return head;

    }
    public TreeNode convertNode(TreeNode root,TreeNode lastList){
        if(root == null){
            return null;
        }
        TreeNode cur =root;
        if(cur.left != null){
            lastList = convertNode(cur.left,lastList);
        }
        cur.left = lastList;
        if(lastList != null){
            lastList.right = cur;
        }
        lastList = cur;
        if(cur.right != null){
            lastList = convertNode(cur.right,lastList);
        }
        return lastList;
    }
}
