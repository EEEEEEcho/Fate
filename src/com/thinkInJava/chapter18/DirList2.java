package com.thinkInJava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regix){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regix);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }
        else{
            list = path.list(new DirFilter(args[0]));
        }
        assert list != null;
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String diename: list){
            System.out.println(diename);
        }
    }
}
