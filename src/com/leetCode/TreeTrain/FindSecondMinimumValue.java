package com.leetCode.TreeTrain;

import java.util.TreeSet;

public class FindSecondMinimumValue {
    /**
     * 通过深度优先搜索遍历树，并使用集合结构唯一性记录树中的每个唯一值。
     * 然后，我们将查看第二个最小值的记录值。第一个最小值必须是 root.val。
     */
    TreeSet<Integer> set;
    public int findSecondMinimumValue(TreeNode root) {
        set = new TreeSet<>();
        dfs(root);
        if (set.size() == 1){
            return -1;
        }
        set.pollFirst();
        return set.first();
    }

    public void dfs(TreeNode node){
        if (node == null){
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
