package com.thinkInJava.chapter18;

import java.io.File;
import java.io.IOException;

/**
 * 策略设计模式
 */
public class ProcessFiles {
    public interface Strategy{      //策略接口
        void process(File file);
    }
    private Strategy strategy;      //策略
    private String ext;             //文件后缀
    public ProcessFiles(Strategy strategy,String ext){
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args){
        try{
            if(args.length == 0){
                processDirectoryTree(new File("."));
            }
            else{
                for (String arg : args){
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }
                    else{
                        if(!arg.endsWith("." + ext)){
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for(File f : Directory.walk(root.getAbsolutePath(),".*\\." + ext)){
            strategy.process(f.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy(){
            //定制一个策略，该策略是打印文件名称
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
