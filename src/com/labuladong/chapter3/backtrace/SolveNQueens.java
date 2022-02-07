package com.labuladong.chapter3.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {
    private ArrayList<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        dfs(0,board);
        return ans;
    }
    public void dfs(int row,List<String> board){
        if (row == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }
        else{
            //一行的长度
            int n = board.get(row).length();

            for (int i = 0; i < n; i++) {
                //做选择，判断该行的i位置可不可以
                if (!isValid(board,row,i)){
                    continue;
                }
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.replace(i,i + 1,"Q");
                //board.get(row).
                board.remove(row);
                board.add(row,sb.toString());
                dfs(row + 1,board);
                StringBuilder st = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    st.append(".");
                }
                board.remove(row);
                board.add(row,st.toString());
            }
        }
    }

    /**
     * 判断皇后放在第row行，第col列是否合法
     * @param board 棋盘
     * @param row 行
     * @param col 列
     * @return 合法性
     */
    public boolean isValid(List<String> board,int row,int col){
        //检查这一列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        //检查左上方有没有皇后
        for (int i = row,j = col; i >= 0 && j >= 0 ; i--,j--) {
            if (board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        //检查右上方有没有皇后
        for (int i = row,j = col; i >= 0 && j < board.get(row).length(); i--,j ++) {
            if (board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        s.solveNQueens(1);
//        StringBuilder sb = new StringBuilder("....");
//        sb.replace(0,1,"Q");
//        System.out.println(sb.toString());
//        LinkedList<String> l = new LinkedList<>();
//        l.add("12345");
//        l.add("54321");
//        l.add("78945");
//        l.remove(1);
//        System.out.println(l);
//        l.add(1,"74562");
//        System.out.println(l);
    }
}
