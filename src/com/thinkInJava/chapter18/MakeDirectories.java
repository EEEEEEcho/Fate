package com.thinkInJava.chapter18;

import java.io.File;

public class MakeDirectories {
    private static void usage(){
        System.err.println(
                "Usage : MakeDirectories path1 ...\n" +
                        "Create each path\n"+
                        "Usage : MakeDirectories -d path1 ...\n" +
                        "Delete each path\n" +
                        "Usage : MakeDirectories -r path1 path2\n" +
                        "Renames from path1 to path2"
        );
        System.exit(1);
    }
    private static void fileData(File f){
        System.out.println("Absolute path : " + f.getAbsolutePath());
        System.out.println("Can Read : " + f.canRead());
        System.out.println("Can Write : " + f.canWrite());
        System.out.println("GetName : " + f.getName());
        System.out.println("GetParent : " + f.getParent());
        System.out.println("GetPath : " + f.getPath());
        System.out.println("Length : " + f.length());
        System.out.println("LastModify : " + f.lastModified());
        if(f.isFile()){
            System.out.println("f is file");
        }
        else if(f.isDirectory()){
            System.out.println("f is Directory");
        }
    }

    public static void main(String[] args) {
        if(args.length < 1){
            usage();
        }
        if(args[0].equals("-r")){
            if(args.length != 3){
                usage();
            }
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean delete = false;
        if(args[0].equals("-d")){
            count ++;
            delete = true;
        }
        count --;
        while (++count < args.length){
            File f = new File(args[count]);
            if(f.exists()){
                System.out.println(f + "exist");
                if (delete){
                    System.out.println("deleting file ...." + f);
                    f.delete();
                }
            }
            else{
                if(!delete){
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}
