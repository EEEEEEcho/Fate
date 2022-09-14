package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    HashMap<String,Integer> hashMap = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.postOrder(root);
        return ans;
    }

    public String postOrder(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = postOrder(root.left);
        String right = postOrder(root.right);

        String str = left + "," + right + "," + root.val;

        Integer times = hashMap.getOrDefault(str, 0);
        if (times == 1){
            //已经出现过一次，只在出现的第一次时添加进去
            ans.add(root);
        }
        hashMap.put(str,times + 1);
        return str;
    }
}
