package com.theswordreferstooffer.offer;

public class StringToInteger {

    int StrToInt(String str) {



        if(str == "" || str.length() == 0 || str == null){
            return 0;
        }
        char op = str.charAt(0);
        int hasOp;
        if(op == '+' || op == '-'){
            hasOp = 1;
        }
        else {
            hasOp = 0;
        }
        int result = 0;
        for(int i=str.length() - 1,j = 0;i >= hasOp;i --,j ++){
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                int tmp = (int)((str.charAt(i) - 48) * Math.pow(10,j));
                System.out.println(tmp);
                result += tmp;
                if(result > Integer.MAX_VALUE){
                    return 0;
                }
            }
            else {
                return 0;
            }
        }
        System.out.println(result);
        if (op == '+') {
            return result;
        }
        else if(op == '-'){
            return 0 - result;
        }
        return result;
    }
    public int stringToInt(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int mark = 0;
        int number = 0;
        char chars[] = str.toCharArray();
        if(chars[0] == '-'){
            mark = 1;
        }
        for(int i = mark;i < chars.length;i ++){
            if(chars[i] == '+'){
                continue;
            }
            if(chars[i] < 48 || chars[i] > 57){
                return 0;
            }
            number = number * 10 + chars[i] - 48;
            if(number == Integer.MAX_VALUE / 10){
                //判断是否超过最小int值-2147483648
                if(mark == 1 && chars[chars.length - 1] - 48 > 8){
                    return 0;
                }
                //判断是否超过最大int值+2147483647
                if(mark == 0 && chars[chars.length - 1] - 48 > 7){
                    return 0;
                }

            }
        }
        return mark == 0 ? number : -number;
    }
    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(s.StrToInt("-2147483649"));
        System.out.println(s.stringToInt("-2147483649"));
    }
}
