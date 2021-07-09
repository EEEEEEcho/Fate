package com.code.StackTrain;

public class MinOperations {
    public int minOperations(String[] logs) {
        int result = 0;
        for(int i=0;i < logs.length;i ++){
//            if(logs[i].contains("d")){
//                result = Integer.parseInt(String.valueOf(logs[i].charAt(1)));
//            }
            if(!logs[i].equals("../") && !logs[i].equals("./")){
                result ++;
            }
            else if(logs[i].equals("../")){
                result -= 1;
                if(result < 0){
                    result = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));

    }
}
