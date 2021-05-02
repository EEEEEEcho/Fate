package com.leetCode.TreeTrain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {
    /**
     * 这是一棵二叉搜索树，其中序遍历是有序的。、
     * 我们从根节点开始遍历；
     *
     * 如果当前节点的值大于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
     *
     * 如果当前节点的值小于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
     *
     * 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，pp 和 qq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true){
            if(p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }
            else if(p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }
            else{
                break;
            }
        }
        return ancestor;
    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> treeNodes = new ArrayList<>();
//        Stack<TreeNode> traceStack = new Stack<>();
//        traceStack.push(root);
//        while (!traceStack.isEmpty()){
//            TreeNode treeNode = traceStack.pop();
//            if(treeNode != null){
//                treeNodes.add(treeNode);
//                traceStack.push(treeNode.right);
//                traceStack.push(treeNode.left);
//            }
//        }
//
//        int pIndex = 0;
//        int qIndex = 0;
//        for (int i = 0; i < treeNodes.size(); i++) {
//            if(p.val == treeNodes.get(i).val){
//                pIndex = i;
//            }
//            if(q.val == treeNodes.get(i).val){
//                qIndex = i;
//            }
//        }
//        if(pIndex > qIndex){
//            return treeNodes.get(qIndex - 1);
//        }
//        return treeNodes.get(pIndex - 1);
//    }
//    public List<TreeNode> preOrder(TreeNode root){
//        if(root == null){
//            return null;
//        }
//        List<TreeNode> resultList = new ArrayList<>();
//        Stack<TreeNode> traceStack = new Stack<>();
//        traceStack.push(root);
//        while (!traceStack.isEmpty()){
//            TreeNode treeNode = traceStack.pop();
//            if(treeNode != null){
//                resultList.add(treeNode);
//                traceStack.push(treeNode.right);
//                traceStack.push(treeNode.left);
//            }
//        }
//        return resultList;
//    }

}
