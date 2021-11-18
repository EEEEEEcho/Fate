package com.code.Dynamic;

public class GetMaxLen {

    //dp并不是只有一个状态转移方程的，一个状态可以有一个转移方程，
    //需要多个状态，并在多个状态之间取结果的，需要多个状态转移方程
    //题解：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/solution/dong-tai-gui-hua-fen-lei-tao-lun-by-clas-tiuy/
    public int getMaxLen1(int[] nums){
        int ans = 0;
        int posti = 0;  //nums[i]之前乘积为正数的序列长度
        int negati = 0; //nums[i]之前乘积为负数的序列长度
        for (int num : nums){
            if(num == 0){
                // 0 会截断两个序列
                posti = 0;
                negati = 0;
            }
            else if(num > 0){
                // 当前nums[i] > 0
                if(negati > 0){
                    //如果前面有了负数序列。那么乘一个大于0的数，这个序列肯定 + 1
                    negati ++;
                }
                //posti无论如何都会增加
                posti ++;
            }
            else {
                // 当前nums[i] < 0
                if(posti == 0 && negati == 0){
                    //从当前计数
                    negati = 1;
                }
                else if(posti == 0 && negati > 0){
                    //负负得正
                    posti = negati + 1;
                    negati = 1;
                }
                else if(posti > 0 && negati == 0){
                    //负正得负
                    negati = posti + 1;
                    posti = 0;
                }
                else{
                    ////负负得正
                    //负正得负
                    int tmp = posti + 1;
                    posti = negati + 1;
                    negati = tmp;
                }
            }
            ans = Math.max(posti,ans);
        }
        return ans;
    }


    //没有过
    public int getMaxLen(int[] nums) {
        int x = 0;
        int oldStart= 0;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                count ++;
                ans = Math.max(ans,count);
            }
            else if (nums[i] < 0){
                x ++;
                if (x == 2){
                    x = 0;
                    int tmp = count;
                    count = Math.max(count,i - oldStart + 1);
                    ans = Math.max(tmp,count);
                }
                else {
                    ans = Math.max(count,ans);
                    count = 0;
                }
            }
            else{
                ans = Math.max(count,ans);
                count = 0;
                if (i + 1 < nums.length){
                    oldStart = i + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetMaxLen getMaxLen = new GetMaxLen();
        System.out.println(getMaxLen.getMaxLen(new int[]{1,2,3,5,-6,4,0,10}));
    }
}
