package com.labuladong.chapter2.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 后序版本
 */
public class Codec2 {
    private final String END = "#";
    private final String SPT = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(TreeNode root,StringBuilder sb){
        if (root == null){
            sb.append(END).append(SPT);
            return;
        }
        serialize(root.left,sb);
        serialize(root.right,sb);
        sb.append(root.val).append(SPT);
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(SPT);
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(split));
        return deserialize(nodes);
    }
    //这里要注意，后序遍历中，根节点是在最右边。而且后序遍历构造出来的序列是【左子树、右子树、根】的结构
    //一定要先还原出右子树，再能还原左子树
    public TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()) return null;
        //从后往前取，还原的时候并没有依照构造时的顺序
        String value = nodes.removeLast();
        if (value.equals(END)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }
}
