package com.code.EveryDay;

public class FindTheWinner {
    //约瑟夫环
    public int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }
}
