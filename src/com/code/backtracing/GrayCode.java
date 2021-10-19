package com.code.backtracing;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /**
     * 我的解答，与格雷序不同，没有通过
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0){
            ans.add(0);
        }
        else{
            dfs(0,n,ans,0);
        }
        return ans;
    }
    public void dfs(int pow,int n,List<Integer> ans,int sum){
        if(pow == n){
            ans.add(sum);
        }
        else {
            for (int i = 0; i < 2; i++) {
                sum += Math.pow(2,pow) * i;
                dfs(pow+ 1,n,ans,sum);
                sum -= Math.pow(2,pow) * i;
            }
        }
    }
    //题解：镜像法
    //https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
