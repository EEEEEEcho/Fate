package com.theswordreferstooffer.offer;

import java.util.Arrays;

public class VerifySquenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同
     *
     * 先找到右子树的开始位置，然后分别进行左右子树递归处理。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        int rstart = 0;
        int rootindex = sequence.length - 1;
        for(int i=0;i < rootindex;i ++){
            //比根小的都是左子树
            if(sequence[i] < sequence[rootindex]){
                rstart++;
            }
        }
        if(rstart == 0){
            //全部都是右子树没有左子树 从右子树开始再找
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,rootindex));
            return true;
        }
        for(int i=rstart;i < rootindex;i ++){
            //如果右子树中有比根节点小的，那么就不是一个二叉排序树
            if(sequence[i] <= sequence[rootindex]){
                return false;
            }
        }
        //递归查找
        VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,rstart));
        VerifySquenceOfBST(Arrays.copyOfRange(sequence,rstart,rootindex));
        return true;
    }
}
