package com.echo;

import java.util.*;

class TreeNode{
    int weight;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int weight){
        this.weight = weight;
    }
    public TreeNode(){

    }
}
public class CompleteBinaryTree {

    /**
     * 有待改进
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int nums[] = new int[n];
            for(int i=0;i < n;i ++){
                nums[i] = scanner.nextInt();
            }
            TreeNode root = null;
            root = createTree(root,nums,0);
            //preOrder(root);
            int level = scanner.nextInt();
            List<TreeNode> list= getNodesByLevel(root,level);
            if(list.size() == 0){
                System.out.println("EMPTY");
            }
            else{
                for(TreeNode treeNode:list){
                    System.out.print(treeNode.weight+" ");
                }
                System.out.println();
            }
        }
    }
    public static TreeNode createTree(TreeNode root,int nums[],int index){
        if(index >= nums.length){
            return null;
        }
        root = new TreeNode(nums[index]);
        root.leftChild = createTree(root.leftChild,nums,2*index + 1);
        root.rightChild = createTree(root.rightChild,nums,index*2+2);
        return root;
    }
    public static List<TreeNode> getNodesByLevel(TreeNode root,Integer targetLevel){
        if(root == null){
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> levelNodes = new ArrayList<>();
        int level = 0;
        if(level == targetLevel){
            return levelNodes;
        }
        TreeNode nextLevelFirstNode = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(nextLevelFirstNode != null && Objects.equals(head.weight,nextLevelFirstNode.weight)){
                level ++;
                nextLevelFirstNode = null;
            }

            if(level == targetLevel){
                levelNodes.add(head);
            }
            else if(level > targetLevel){
                return levelNodes;
            }

            if(head.leftChild != null){
                queue.offer(head.leftChild);
                if(nextLevelFirstNode == null){
                    nextLevelFirstNode = head.leftChild;
                }
            }
            if(head.rightChild != null){
                queue.offer(head.rightChild);
                if(nextLevelFirstNode == null){
                    nextLevelFirstNode = head.rightChild;
                }
            }

        }
        return levelNodes;
    }
//    public static void preOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        System.out.print(root.weight + " ");
//        preOrder(root.leftChild);
//        preOrder(root.rightChild);
//    }
}
