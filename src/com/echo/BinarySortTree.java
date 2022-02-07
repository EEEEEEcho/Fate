package com.echo;

import java.util.Scanner;
import java.util.Stack;

class BinaryTreeNode {
    int weight;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int weight, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.weight = weight;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class BinarySortTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            BinaryTreeNode bt = null;
            while (n > 0) {
                int weight = scanner.nextInt();
                bt = createSortTree(bt, weight);
                n--;
            }
            preorder(bt);
            System.out.println();
            inorder(bt);
            System.out.println();
            postorder(bt);
            System.out.println();
        }

    }

    public static BinaryTreeNode createSortTree(BinaryTreeNode root, int weight) {
        BinaryTreeNode node = new BinaryTreeNode(weight, null, null);
        if (root == null) {
            root = node;
        } else {
            BinaryTreeNode currentNode = root;
            BinaryTreeNode parentNode;
            while (true) {
                //记录父节点
                parentNode = currentNode;
                if (weight > parentNode.weight) {
                    //当前节点往右走
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        //走到头了
                        parentNode.rightChild = node;
                        return root;
                    }
                }
                if (weight < parentNode.weight) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = node;
                        return root;
                    }
                }
                if (weight == parentNode.weight) {
                    return root;
                }
            }
        }
        return root;
    }

    public static void inorder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                //左，压栈一次就是往左走一次
                stack.push(node);
                node = node.leftChild;
            } else {
                //左走到头了 该根了
                node = stack.pop();
                System.out.print(node.weight + " ");
                //右
                node = node.rightChild;
            }
        }
    }

    public static void preorder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                //根
                System.out.print(node.weight + " ");
                stack.push(node);
                //左
                node = node.leftChild;
            } else {
                //右
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    public static void postorder(BinaryTreeNode root) {
        BinaryTreeNode node = root;
        BinaryTreeNode preNode = null; //记录上一次输出的节点
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);   //根入栈
        while (!stack.isEmpty()) {
            node = stack.peek();
            if ((node.leftChild == null && node.rightChild == null) ||
                    (preNode != null && (preNode == node.leftChild || preNode == node.rightChild))) {
                //结点的左右孩子都为空，证明遍历到了叶子上
                //或者前驱的记录不为空，且前驱节点是当前节点的左孩子或者右孩子
                System.out.print(node.weight + " ");
                preNode = node;
                stack.pop();
            }else{
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }

                if (node.leftChild != null) {
                    stack.push(node.leftChild);
                }

            }
        }
    }
}
