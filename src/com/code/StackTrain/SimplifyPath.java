package com.code.StackTrain;

import java.util.Arrays;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        if (path.length() == 1){
            return "/";
        }
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder("/");
        for (int i = 1; i < paths.length; i++) {
            if(!paths[i].equals(".") && paths[i].length() != 0){
                if (paths[i].equals("..")){
                    if(stack.size() > 0){
                        stack.removeFirst();
                    }
                }
                else{
                    stack.addFirst(paths[i]);
                }
            }
        }
        for (int i = stack.size() - 1;i >= 0;i --){
            sb.append(stack.get(i));
            if (i != 0){
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String s = sp.simplifyPath("/./");
    }
}
