package com.theswordreferstooffer.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * ：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子 节点，打印路径中的值
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return listAll;
        }
        target -= root.val;
        list.add(root.val);
        //找到了
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        //，找不到回退
        list.remove(list.size() - 1);
        return listAll;
    }
}
