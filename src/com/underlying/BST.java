package com.underlying;

public class BST <Key extends Comparable<Key>,Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int n;  //以该节点为根的子树中的结点总数

        public Node(Key key,Value value,int n){
            this.key = key;
            this.value = value;
            this.n = n;
        }

    }


    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node,Key key){
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right,key);
        else if (cmp < 0) return get(node.left,key);
        else return node.value;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    private Node put(Node node,Key key,Value value){
        if (node == null) return new Node(key,value,1);
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.right = put(node.right,key,value);
        else if (cmp < 0) node.left = put(node.left,key,value);
        else node.value = value;
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node == null) return 0;
        return node.n;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node node){
        if (node.left == null) return node;
        return min(node.left);
    }

    public Key floor(Key key){
        return floor(root,key).key;
    }

    private Node floor(Node node,Key key){
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return floor(node.left,key);
        Node t = floor(node.right,key);
        if (t != null) return t;
        else return node;
    }

    public int rank(Key key){
        return rank(root,key);
    }

    private int rank(Node node,Key key){
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(node.left,key);
        else if (cmp > 0) return 1 + size(node.left) + rank(node.right,key);
        else return size(node.left);
    }

    public int select(){
        return 0;
    }
}
