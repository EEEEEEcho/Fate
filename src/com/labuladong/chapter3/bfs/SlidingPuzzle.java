package com.labuladong.chapter3.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
//        Queue<String> index = new LinkedList<>();
        int step = 0;
        String target = "123450";
        String s = serialize(board);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0){
                    sb.append("|").append(i).append(",").append(j);
                    break;
                }
            }
        }
        queue.offer(sb.toString());
        visited.add(s);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                String[] split = poll.split("\\|");
                String node = split[0];
                int m = Integer.parseInt(split[1].split(",")[0]);
                int n = Integer.parseInt(split[1].split(",")[1]);
                board = deserialize(node);
                if (node.equals(target)){
                    return step;
                }
                if (m - 1 >= 0){
                    int tmp = board[m - 1][n];
                    board[m - 1][n] = board[m][n];
                    board[m][n] = tmp;
                    String up = serialize(board);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up + "|" + (m - 1) + "," + n);
                        tmp = board[m - 1][n];
                        board[m - 1][n] = board[m][n];
                        board[m][n] = tmp;
                    }
                }
                if (m + 1 < board.length){
                    int tmp = board[m + 1][n];
                    board[m + 1][n] = board[m][n];
                    board[m][n] = tmp;
                    String down = serialize(board);
                    if (!visited.contains(down)){
                        visited.add(down);
                        queue.offer(down + "|" + (m + 1) + "," + n);
                        tmp = board[m + 1][n];
                        board[m + 1][n] = board[m][n];
                        board[m][n] = tmp;
                    }
                }
                if (n - 1 >= 0){
                    int tmp = board[m][n - 1];
                    board[m][n - 1] = board[m][n];
                    board[m][n] = tmp;
                    String left = serialize(board);
                    if (!visited.contains(left)){
                        visited.add(left);
                        queue.offer(left + "|" + m + "," + (n - 1));
                        tmp = board[m][n - 1];
                        board[m][n - 1] = board[m][n];
                        board[m][n] = tmp;
                    }
                }
                if (n + 1 < board[0].length){
                    int tmp = board[m][n + 1];
                    board[m][n + 1] = board[m][n];
                    board[m][n] = tmp;
                    String right = serialize(board);
                    if (!visited.contains(right)){
                        visited.add(right);
                        queue.offer(right + "|" + m + "," + (n + 1));
                        tmp = board[m][n + 1];
                        board[m][n + 1] = board[m][n];
                        board[m][n] = tmp;
                    }
                }
            }
            step ++;
        }
        return -1;
    }
    private String serialize(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
    private int[][] deserialize(String s){
        int[][] board = new int[2][3];
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(k ++)));
            }
        }
        return board;
    }
    public static void main(String[] args) {
        SlidingPuzzle s = new SlidingPuzzle();
        int i = s.slidingPuzzle(new int[][]{{1, 2, 3}, {5,4,0}});
        System.out.println(i);
    }
}
