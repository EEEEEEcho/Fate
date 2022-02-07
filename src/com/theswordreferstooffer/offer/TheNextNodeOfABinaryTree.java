package com.theswordreferstooffer.offer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class TheNextNodeOfABinaryTree {
    //该题目就是要找到中序遍历下的某个节点的下一个节点
    //中序遍历：左根右  如果节点右孩子存在。那么中序的下一个节点就是右孩子的左子树的最左节点
    //如果是非根节点：1.如果该节点是其父节点的左孩子，那么返回父节点。否则继续向上遍历其父节点的父节点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        //如果节点右孩子存在。那么中序的下一个节点就是右孩子的左子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //next指针指向其父节点
        while (pNode.next != null){
            //找第一个节点，这个节点的左孩子 是所求节点。
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
