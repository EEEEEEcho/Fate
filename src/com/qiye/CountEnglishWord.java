package com.qiye;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountEnglishWord {
    //此处有个坑 如果(\w+[']+\w+)|(\w+) 改为(\w+)|(\w+[']+\w+)会按照表达式编译的结果，先匹配所有英文字母
    //就会出现无法匹配诸如it's的情况,匹配成it s而it's算作一个单词。
    //(\d+)匹配年月等连续数字 (\w+[-]+\w+)匹配带有连字符的单词  (\w+[']+\w+)匹配带有'的单词 (\w+)匹配普通单词
    public static final String REG = "(\\d+)|(\\w+[-]+\\w+)|(\\w+[']+\\w+)|(\\w+)";
    public static Pattern pattern = Pattern.compile(REG);

    public static void main(String[] args) throws IOException {
        //文件路径
        String fileName = "H:\\JavaProject\\Fate\\src\\com\\qiye\\EnglishText.txt";

        //输入流
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //按行读取
        String textLine = bufferedReader.readLine();
        int sum = countWordsByLine(textLine);
        while (textLine != null){
            textLine = bufferedReader.readLine();
            sum += countWordsByLine(textLine);
        }
        System.out.println(sum);

        //关闭流
        bufferedReader.close();
        fileReader.close();
    }
    public static int countWordsByLine(String line){
        if(line == null){
            return 0;
        }
        int result = 0;
        Matcher matcher = pattern.matcher(line);

        //如果匹配到一个单词 统计数目加一
        while (matcher.find()){
            if(matcher.group() != null){
                System.out.print(matcher.group() + " ");
                result ++;
            }
        }

        //如果一行中有一个单词没有写完，有连字符，那么匹配以后肯定会再下一行多匹配一次，所以减一
        if(line.endsWith("-")){
            result -= 1;
        }
        return result;
    }
}
