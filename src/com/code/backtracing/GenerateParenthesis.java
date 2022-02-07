package com.code.backtracing;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    //["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs("",n,n,ans);
        return ans;
    }
    public void dfs(String s,int left,int right,List<String> res){
        if (left == 0 && right == 0){
            //如果左括号也没了，右括号也没了，添加到结果集
            res.add(s.toString());
            return;
        }
        if (left == right){
            //如果剩余的左右括号数量相等。那么只能添加左括号
            dfs(s + "(",left - 1,right,res);
        }
        else if(left < right){
            //如果剩余的左括号数量小于右括号。那么既可以添加左括号，也可以添加右括号
            if(left > 0) {
                //如果还有左括号
                dfs(s + "(", left - 1, right, res);
            }
            dfs(s + ")",left,right - 1,res);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
