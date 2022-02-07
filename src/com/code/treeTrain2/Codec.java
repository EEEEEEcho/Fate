package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {
    private final String SPEC = ",";
    private final String NULL = "#";
    //前序遍历的方式，将二叉树序列化为字符串
    //后序也可以，只不过还原的时候，是先还原的右子树，因为根节点都在最后面
    //中序不行，找不到根节点
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        buildStr(root,sb);
        return sb.toString();
    }
    private void buildStr(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append(NULL).append(SPEC);
            return;
        }
        sb.append(node.val).append(SPEC);
        buildStr(node.left,sb);
        buildStr(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return buildTree(list);
    }

    private TreeNode buildTree(LinkedList<String> strList){
        if (strList.size() == 0) return null;

        //前序还原，因为数组中保存了null指针的信息，所以只需一个数组即可还原
        String rootVal = strList.removeFirst();
        //这句代码是能够一个数组建立二叉树的核心，知道哪里是null就行了，
        //左子树该为null的部分都是null，填完左子树自然就到了右子树
        if (rootVal.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        root.left = buildTree(strList);
        root.right = buildTree(strList);
        return root;
    }

}
