package com.code.carl.tree.reverse;

import com.code.carl.tree.TreeNode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public static void main(String[] args) {

    }
    public static void countWords(String path){
        File file = new File(path);
        File[] files = file.listFiles();

    }
    static class ReadTask implements Runnable{

        @Override
        public void run() {

        }
    }
}
