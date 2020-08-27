package com.theswordreferstooffer.offer;

/**
 * 0-1背包问题
 * 给定n个重量为w1,w2,w3...wn，其价值为v1,v2,v3...vn的物品和容量为C的背包，求这些物品中最有价值的一个子集
 * 使得在满足背包的容量的前提下，包内的总价值最大
 * 0 - 1 背包问题是指每个物品只能使用一次
 */
public class BagProblem {
    static int n;   //描述物品个数
    static int c;   //描述背包容量
    static int value[]; //描述物品价值
    static int weight[];    //描述物品重量
    public static void main(String[] args) {
        n = 3;
        c = 4;
        value = new int[]{1500,3000,2000};
        weight = new int[]{1,4,3};
        //初始化
        int dp[][] = new int[n][c];
        for(int i=0;i < n;i ++){
            for(int j=0;j < c;j ++){
                dp[i][j] = 0;
            }
        }
        //填充网格
        for(int i=0;i < n;i ++){
            for(int j=1; j <= c;j ++){
                if(i == 0){
                    dp[i][j-1] = weight[i] <= j ? value[i] : 0;
                }
                else{
                    int topValue = dp[i-1][j-1];    //上一个网格的值
                    int thisValue;
                    if(weight[i] <= j){
                        if(weight[i] < j){
                            thisValue = value[i] + dp[i - 1][j - weight[i]];    //当前商品的价值 + 剩余空间的价值
                        }
                        else{
                            thisValue = value[i];
                        }
                    }
                    else{
                        thisValue = topValue;
                    }
                    //返回topValue和thisValue中较大的一个
                    dp[i][j - 1] = topValue > thisValue ? topValue : thisValue;
                }
            }
        }

        for(int i = 0;i < n;i ++){
            for(int j =0; j < c;j ++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
