package com.code.backtracing;

public class Exist {
    private final int[][] directs = new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        int[][] mark = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flg = backTracing(board,i,j,word,0,mark);
                if (flg){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backTracing(char[][] board,int m,int n,String word,int index,int[][] mark){
        if (board[m][n] != word.charAt(index)){
            return false;
        }
        else if(index == word.length() - 1){
            return true;
        }
        mark[m][n] = 1;
        boolean res = false;
        for (int i = 0; i < directs.length; i++) {
            int curI = m + directs[i][0];
            int curJ = n + directs[i][1];
            if(curI >=0 && curI < board.length && curJ >=0 && curJ < board[0].length){
                if(mark[curI][curJ] == 0){
                    boolean flg = backTracing(board, curI, curJ, word, index + 1, mark);
                    if (flg){
                        res = true;
                        break;
                    }
                }
            }
        }
        mark[m][n] = 0;
        return res;
    }
}
