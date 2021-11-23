package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    List<TreeNode> res = new ArrayList<>();
    HashMap<String,Integer> map = new HashMap<>();
    /**
     * 重点是思路问题，如何确定遍历的顺序（选择遍历方法），以及如何以字符串的方式序列化二叉树
     * 我要知道以自己为根的子树长啥样，是不是得先知道我的左右子树长啥样，再加上自己，就构成了整棵子树的样子
     * 可以判断本题要使用「后序遍历」框架
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        reverse(root);
        return res;
    }

    public String reverse(TreeNode node){
        if (node == null) return "#";
        String left = reverse(node.left);
        String right = reverse(node.right);

        //遍历到当前节点时，这颗子树长什么样
        String subTree = left + "," + right + "," + node.val;

        //看看里面有没有这颗树
        int freq = map.getOrDefault(subTree,0); //有此键，返回键值，否则返回0
        //出现过一次，加进去,只添加第一次出现时
        if(freq == 1) res.add(node);
        map.put(subTree,freq + 1);
        return subTree;
    }
}
