package com.theswordreferstooffer.offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeBinaryTree {
    //前序遍历二叉树存入字符串中，
    public String Serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    //反序列化。根据前序遍历重建二叉树
    public int index = -1;
    public TreeNode Deserialize(String str) {
        String[] strs = str.split(","); //将序列化之后的序列用,分隔符转化为数组
        index ++;       //索引每次加一
        int len = strs.length;
        TreeNode node = null;
        if(index >= len){   //鲁棒性
            return null;
        }
        if(!strs[index].equals("#")){
            //如果不是叶子节点，继续走，是叶子节点则出递归。
            node = new TreeNode(Integer.valueOf(strs[index]));  //根
            node.left = Deserialize(str);       //左
            node.right = Deserialize(str);      //右
        }
        return node;
    }

    public static void main(String[] args) {
        SerializeBinaryTree s = new SerializeBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(s.Serialize(root));
    }
}
