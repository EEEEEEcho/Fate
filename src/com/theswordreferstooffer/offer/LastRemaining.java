package com.theswordreferstooffer.offer;

/**
 * 约瑟夫环问题
 */
public class LastRemaining {
    /**
     *
     * @param n 总人数 本题要求编号是从 0 到 n-1
     * @param m 数到几返回     编号是从 0 到 m-1
     * @return  最后一个人的编号    若要求的编号为 从1 开始 则最后结果加一即可
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0){
            return -1;
        }
        int ans = 0;
        //i表示一共有i个人时的情况
        for(int i=1;i <= n;i ++){
            ans = (ans + m) % i;
        }
        return ans;
    }
}
