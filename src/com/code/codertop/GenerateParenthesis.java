package com.code.codertop;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return ans;
        backTrace("",n,n);
        return ans;
    }

    /**
     * 递归的去拼接所有的字符串
     * @param str 正在拼接的字符串
     * @param left 左括号的数量，初始为n
     * @param right 右括号的数量，初始为n
     */
    public void backTrace(String str,int left,int right){
        if (left == 0 && right == 0){
            //左括号也拼接完了，右括号也拼接完了。那么整个串拼接完成
            ans.add(str);
            return;
        }
        if (left == right){
            //剩余左右括号数相等且都大于0，只能拼接一个左括号
            backTrace(str + "(",left - 1,right);
        }
        else if(left < right){
            //左括号剩下的比右括号少，可以拼接一个左括号，也可以拼接一个右括号
            //拼一个左边的
            if (left > 0){
                backTrace(str + "(",left - 1,right);
            }
            //拼一个右边的
            backTrace(str + ")",left,right - 1);
        }
    }
}
