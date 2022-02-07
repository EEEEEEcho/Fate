package com.theswordreferstooffer.offer;

public class ThePathOfAMatrix {
    /**
     * 这种题 我向来是不会做的。
     * 回溯法，双层 for 循环，判断每一个点，每次递归调用上下左右四个点，
     * 用 flag 标志是否已经匹配（return），进行判断点的位置是否越界，是否已经正确匹配，
     * 判断矩阵的路径与模式串的第 index 个字符是否匹配。
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int flg[] = new int[matrix.length];
        for(int i=0;i < rows;i ++){
            for(int j=0;j < cols;j ++){
                if(helper(matrix,rows,cols,i,j,str,0,flg)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[] matrix,int rows,int cols,int i,int j,char[] str,int k,int[] flg){
        int index = i * cols + j;    //定位
        if(i < 0|| i>= rows || j < 0 || j >= cols || matrix[index] != str[k] || flg[index] == 1){
            return false;
        }
        if(k == str.length - 1){
            return true;
        }
        flg[index] = 1;
        if(helper(matrix,rows,cols,i-1,j,str,k+1,flg) || helper(matrix,rows,cols,i+1,j,str,k+1,flg) ||
                helper(matrix,rows,cols,i,j-1,str,k + 1,flg)
                || helper(matrix,rows,cols,i,j +1,str,k+1,flg)){
            return true;
        }
        flg[index] = 0;
        return false;
    }

}
