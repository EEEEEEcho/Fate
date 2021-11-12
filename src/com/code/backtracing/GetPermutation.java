package com.code.backtracing;

public class GetPermutation {
    private int index;
    private String result = "";
    public String getPermutation(int n, int k) {
        boolean[] mark = new boolean[n + 1];
        index = k;
        dfs(n,new StringBuilder(),mark);
        return result;
    }
    public void dfs(int n,StringBuilder s,boolean[] mark){
        if (s.length() == n){
            index = index - 1;
            if (index == 0){
                result = s.toString();
            }
        }
        else{
            for (int i = 1; i <= n; i++) {
                if(!result.equals("")){
                    break;
                }
                if(!mark[i]){
                    mark[i] = true;
                    dfs(n,s.append(i),mark);
                    mark[i] = false;
                    s.replace(s.length() - 1,s.length(),"");
                }
            }
        }
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(3,3));
    }
}
