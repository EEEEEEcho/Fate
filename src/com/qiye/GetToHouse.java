package com.qiye;

import java.util.Scanner;

/**
 * 注意到了这个条件，pi(1<=pi<=i)，才想到这是个动态规划
 * 有了上面这个条件为什么就能用动态规划做了呢？因为满足了最优子结构。这个条件保证了可以利用子结构的最优解。
 * 先来分析一下，pi(1<=pi<=i)，这句话意味着传送门不可能把你往前面的门传，如果你想向前走，那么你只能访问该房间偶数次；
 * 假设你现在第一次到达i门，你觉得前面i - 1个房子你都访问了多少次？每个房子访问了多少次我不知道，但是我知道每个房子访问
 * 的次数都是偶数！这一点很重要，不然写不出状态转移方程；这是为什么呢，其实答案就在上一段话，仔细想想，假如前面i - 1中
 * 有一个房子的访问次数不是偶数次，那么，你不可能向前走，更不可能走到i门。
 * 动态规划方程很好写了，设dp[i]为到达i门，并且进入次数为偶数时需要移动的次数
 * 要进入i门，那么就要从i - 1门过来，故访问i - 1门的次数一定为偶数，故dp[i] = dp[i - 1] + 1；
 * 这个时候到达了i门，由于第一次进入，故次数为奇数，因此被送会transform[i]门，dp[i] += 1
 * 这个时候到达transform[i]门，由于之前到达transform[i]门的次数为偶数，因此这次到达的次数就是奇数
 * 故需要求的部分就是从transform[i]门走到 i-1门的距离
 * dp[i-1]是从头走到i-1的距离 dp[transform[i] - 1]就是从头走到transform[i]的距离
 * 所求部分就是dp[i-1] - dp[transform[i] - 1]
 * 走到i-1了 需要再走一步才能到 i门
 * dp[i] +1
 * 求个总的公式：dp[i] = dp[i - 1] * 2  - dp[transForm[i] - 1] + 2
 */
public class GetToHouse {
    public static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] transForm = new int[n + 1];
        for(int i=1 ; i <= n;i ++){
            transForm[i] = scanner.nextInt();
        }
        int[] dp = new int[n + 1];
        for(int i=1;i <=n; i ++){
            dp[i] = (dp[i - 1] * 2 % mod - dp[transForm[i] - 1] + 2) % mod;
        }
        System.out.println(dp[n] % mod);
    }

}
