package com.theswordreferstooffer.offer;

public class NumberOf1Between1AndN {
    //我的做法
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=1; i <= n;i ++){
            int cau = i;
            while (cau > 0){
                int tmp = cau % 10;
                if(tmp == 1){
                    count ++;
                }
                cau = cau / 10;
            }
        }
        return count;
    }

    //书上的做法
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        for(int i = 1;i <= n;i *= 10){
            int a = n / i;
            int b = n % i;
            count += (a+8) / 10 * i;
            if(a % 10 == 1){
                count += b + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOf1Between1AndN n = new NumberOf1Between1AndN();
        int re = n.NumberOf1Between1AndN_Solution(13);
        System.out.println(re);
    }
}
