package com.code.treeTrain2;

public class Connect {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left,root.right);
        return root;
    }
    //增加函数参数，一个节点做不到，我们就给他安排两个节点
    public void connectTwoNode(Node left,Node right){
        if (left == null || right == null){
            return;
        }
        //前序遍历
        left.next = right;
        //先连自己的
        connectTwoNode(left.left,left.right);
        connectTwoNode(right.left,right.right);
        //再和别人连
        connectTwoNode(left.right,right.left);
    }
}
