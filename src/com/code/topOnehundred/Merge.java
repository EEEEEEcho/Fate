package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56.合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return new int[][]{intervals[0]};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                else{
                    return o1[1] - o2[1];
                }
            }
        });
        int m = intervals[0][0];
        int n = intervals[0][1];
        LinkedList<ArrayList<Integer>> list = new LinkedList<>();
        list.add(new ArrayList<>(Arrays.asList(m,n)));
        for (int i = 1; i < intervals.length; i++) {
            ArrayList<Integer> last = list.getLast();
            if (last.get(1) >= intervals[i][0] && intervals[i][1] >= last.get(1)){
                list.removeLast();
                list.addLast(new ArrayList<>(Arrays.asList(last.get(0),intervals[i][1])));
            }
            else if (intervals[i][0] > last.get(0) && intervals[i][1] < last.get(1)){
                continue;
            }
            else{
                list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] merge1 = merge.merge(new int[][]{{1, 4},{4, 6}});
        for (int i = 0; i < merge1.length; i++) {
            System.out.println(Arrays.toString(merge1[i]));
        }
    }
}
