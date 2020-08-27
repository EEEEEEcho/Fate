package com.theswordreferstooffer.offer;

public class RegMatch {
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null){
            return false;
        }
        if(str.length == 1){
            if(pattern.length == 1){
                if(str[0] == pattern[0] || pattern[0] == '.'){
                    return true;
                }
                return false;
            }
        }
        int sindex = 0; //匹配串指针
        int pindex = 0; //模式串指针
        return matchIndex(str,sindex,pattern,pindex);
    }
    public boolean matchIndex(char str[],int sindex,char[] partten,int pindex){
        //匹配串和模式串都走到末尾
        if(sindex == str.length && pindex == partten.length){
            return true;
        }
        //如果匹配串没有到末尾而模式串到了末尾 返回false
        if(sindex != str.length && pindex == partten.length){
            return false;
        }
        //若模式串第二个字符是*
        if(pindex + 1 < partten.length && partten[pindex + 1] == '*'){
            //匹配串和模式串第一个字符相等 且模式串第二个字符是*,或者模式串第一个字符是. 且模式串第二个字符是*
            if((sindex != str.length && partten[pindex] == str[sindex]) ||
                    (sindex != str.length && partten[pindex] == '.')){
                //3种匹配方式
                //匹配串后移一个字符，模式串后移两个字符
                return matchIndex(str,sindex + 1,partten,pindex + 2)
                        //模式串后移两个字符，相当于x*被忽略
                        || matchIndex(str,sindex,partten,pindex + 2)
                        //字符串后移一位，模式串不变，即继续匹配字符下一位，因为*可以匹配多位
                        || matchIndex(str,sindex + 1,partten,pindex);
            }
            //当模式中的第二个字符是*时，如果匹配串第一个字符跟模式第一个字符不匹配。则模式串后移两个字符，继续匹配
            else{
                return matchIndex(str,sindex,partten,pindex + 2);
            }
        }
        //若模式串第二个字符不是*
        if((sindex != str.length && partten[pindex] == str[sindex]) || (sindex != str.length && partten[pindex] == '.')){
            return matchIndex(str,sindex + 1,partten,pindex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        RegMatch r = new RegMatch();
        System.out.println(r.match(new char[]{'a','a','a'},new char[]{'a','a','.','a'}));
    }
}
