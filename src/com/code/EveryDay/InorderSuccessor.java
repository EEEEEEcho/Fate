package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderSuccessor {
    //这种当前节点的前一个结点或者下一个节点，多用双指针判断
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        TreeNode pre = null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if (p == pre) return cur;
//
//            pre = cur;
//            cur = cur.right;
            if (cur != null){

                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if (pre == p){
                    return cur;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return null;
    }
}
