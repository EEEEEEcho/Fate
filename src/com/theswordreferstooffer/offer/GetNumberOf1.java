package com.theswordreferstooffer.offer;

public class GetNumberOf1 {
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0;i < s.length();i ++){
            if(s.charAt(i) == '1'){
                count ++;
            }
        }
        return count;
    }

    /**
     * ：a&(a-1)的结果会将 a 最右边的 1 变为 0，直到 a = 0
     * ，还可以先将 a&1 != 0，然后右移 1 位，但不能计算负数的值，
     * @param n
     * @return
     */
    public int NumberOf11(int n) {
        int count = 0;
        while (n != 0){
            count ++;
            n = (n-1)&n;
            System.out.println(Integer.toBinaryString(n));
        }
        return count;
    }

    public static void main(String[] args) {
        int n = new GetNumberOf1().NumberOf11(39);
    }
}
