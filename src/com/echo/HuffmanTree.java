package com.echo;
import java.util.*;

class Tree{
    int data;
    Tree left;
    Tree right;
    Tree(int data){
        this.data = data;
    }
}
public class HuffmanTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Tree> treeList = new ArrayList<Tree>();
        //构建N棵只有一个根节点的树
        for(int i=0;i < n;i ++){
            treeList.add(new Tree(input.nextInt()));
        }
        //构造哈夫曼树进行N-1次构造，删除合并操作
        for(int i = 0;i < n-1;i ++){
            createHuff(treeList);
        }
        //createHuff(treeList);
        int WPL = getWPL(treeList.get(0),0);
        System.out.println(WPL);
    }
    public static void createHuff(List<Tree> list){
        //重写排序规则，找出两个最小的树，合并为一个新的树 并添加进集合中 删除原来集合
        Collections.sort(list, new Comparator<Tree>() {
            @Override
            public int compare(Tree t1, Tree t2) {
                if(t1.data > t2.data){
                    return 1;
                }
                if(t1.data == t2.data){
                    return 0;
                }
                return -1;
            }
        });
        //找出最小的两棵树
        Tree t1 = list.get(0);
        Tree t2 = list.get(1);
        //合并两颗最小的树
        Tree t = new Tree(t1.data + t2.data);
        t.left = t1;
        t.right = t2;
        //将两个最小的树从集合中移除（因为已经构造了一个新的树）
        list.remove(t1);
        list.remove(t2);
        //将新的树添加进集合
        list.add(t);
    }
    public static int getWPL(Tree t, int n){
        if(t.left == null && t.right == null){
            return t.data * n;
        }
        return getWPL(t.left,n + 1) + getWPL(t.right,n + 1);
    }
}
