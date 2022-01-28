package com.labuladong.chapter2.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    HashMap<String,Integer> countMap = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.traverse(root);
        return ans;
    }
    //序列化二叉树，然后可以通过存储序列化之后的结果判断是否有重复的子树
    private String traverse(TreeNode root){
        if (root == null) return "#";
        //后序遍历，因为一棵树，在遍历到根节点的时候，要知道自己长什么样，就需要后序遍历
        String left = traverse(root.left);
        String right = traverse(root.right);

        String tree = left + "," + right + "," + root.val;
        Integer freq = countMap.getOrDefault(tree, 0);
        if (freq == 1){
            ans.add(root);
        }
        countMap.put(tree,freq + 1);
        return tree;
    }
}
