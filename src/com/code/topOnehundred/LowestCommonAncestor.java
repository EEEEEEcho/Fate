package com.code.topOnehundred;

import com.code.TreeTrain.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    /**
     * 祖先的定义：若节点p在节点 root 的左（右）子树中，或 p=root ，则称 root 是 p 的祖先。
     *
     * 最近公共祖先的定义： 设节点 root为节点p, q的某公共祖先，若其左子节点 root.left和右子节点
     * root.right都不是 p,q的公共祖先，则称root是 “最近的公共祖先” 。
     * 只会出现三种情况
     * p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
     * p=root ，且 q 在 root 的左或右子树中；
     * q=root ，且 p 在 root 的左或右子树中；
     *
     * 所以实际上就是判断，某一个节点node，其左右子树中是否包含p和q，如果包含，那它就是公共节点
     */
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        //终止条件，如果节点是p或者q或者是一个叶子节点那么就返回
        if (node == null || node == p || node == q){
            return node;
        }
        //看看左子树中是否包含p或者q，如果包含，返回的不是null，如果不包含，返回的就是null
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        //看看右子树中是否包含p或者q，如果包含，返回的不是null, 如果不包含，返回的就是null
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        //如果左右子树返回的都不是null,那么当前节点就是最近的公共父节点
        if (left != null && right != null){
            return node;
        }
        //如果左子树返回的为空，右子树返回的不为空，那么就证明p或者q是二者的最近公共父节点。
        else if(left == null && right != null){
            return right;
        }
        //同理右子树
        else if(right == null && left != null){
            return left;
        }
        //两边都返回null，那就是p q不在两边的子树中
        else{
            return null;
        }
    }

    //解法2：路径记录法。这个很好，以后用得到
    HashMap<Integer,TreeNode> parent = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    public void dfs(TreeNode root){
        //建立一个，子节点到父节点的映射
        if (root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor2(TreeNode node, TreeNode p, TreeNode q) {
        //先建立映射
        dfs(node);
        //从映射表中，找到一条从p节点到根节点的路径
        while (p != null){
            visited.add(p);
            p = parent.get(p.val);
        }
        while (q != null){
            //从映射表中，找到一条从q节点到根节点的路径，如果p到根节点的路径中包含此路径中的点，那么该点就是公共父节点
            if (visited.contains(q)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
