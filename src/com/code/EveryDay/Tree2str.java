package com.code.EveryDay;

import com.code.TreeTrain.TreeNode;

public class Tree2str {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.replace(0,1,"").replace(sb.length() - 1,sb.length(),"").toString();
    }
    private void preOrder(TreeNode node,StringBuilder sb){
        sb.append("(");
        sb.append(node.val);
        if(node.left != null && node.right != null){
            preOrder(node.left,sb);
            preOrder(node.right,sb);
        }
        else if(node.left == null && node.right != null){
            sb.append("()");
            preOrder(node.right,sb);
        }
        else if(node.left != null && node.right == null){
            preOrder(node.left,sb);
        }
        sb.append(")");
    }
}
