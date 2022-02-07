package com.labuladong.chapter2.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树的序列化和反序列化，
 * 在知道树中null信息的情况下是可以仅通过一个序列的遍历还原出二叉树的
 * 这是先序版本
 */
public class Codec {
    private final String END = "#";
    private final String SPT = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    private void serialize(TreeNode node,StringBuilder sb){
        if (node == null){
            sb.append(END).append(SPT);
            return;
        }
        sb.append(node.val).append(SPT);
        serialize(node.left,sb);
        serialize(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(SPT);
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(strings));
        return deserialize(nodes);
    }
    //中序 的结果是【根、左子树、右子树】所以还原时也是该顺序
    private TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()) return null;
        String value = nodes.removeFirst();
        //单从先序遍历就可以还原的主要原因就在这里。能够判断出空指针
        //直接从空指针信息中就能找到子树
        if (value.equals(END)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
