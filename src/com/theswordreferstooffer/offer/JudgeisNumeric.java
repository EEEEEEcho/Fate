package com.theswordreferstooffer.offer;

/**
 * 逐个字符进行判断，e 或 E 和小数点最多出现一次，而 e 或 E 的前一个必 须是数字，且不能是第一个或最后一个字符，
 * 符号的前一个字符不能是 e 或 E。也 可用正则表达式判断
 */
public class JudgeisNumeric {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        int index = 0;
        int ecount = 0;
        int point = 0;
        if(str[0] == '-' || str[0] == '+'){
            index ++;
        }
        for(int i=index;i < str.length;i ++){
            if(str[i] == '-' || str[i] == '+'){
                if(str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                continue;
            }
            if(str[i] == 'e' || str[i] == 'E'){
                ecount ++;
                if(ecount > 1){
                    return false;
                }
                //e 出现在第一个位置或者e前面的不是数字 或者e出现在最后一个位置
                if(i ==0 || str[i - 1] < 48 || str[i - 1] > 57 || i == str.length - 1){
                    return false;
                }
                point ++;
                continue;
            }
            if(str[i] == '.'){
                point ++;
                if (point > 1){
                    return false;
                }
                continue;
            }
            if((str[i] < 48 || str[i] > 57) && str[i] != 'e' && str[i] != 'E'){
                return false;
            }
        }
        return true;

    }
}
