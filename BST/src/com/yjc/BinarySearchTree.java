package com.yjc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0){
            return contains(node.right,e);
        }else {
            return contains(node.left,e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder1(){
        Stack<Node> stack = new Stack<>();
        if (root == null)
            return;
        Node node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            System.out.println(stack.pop().e);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if(stack.isEmpty()) {
                node = null;
            }else {
                node = stack.peek();
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //广度优先遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        Node node = root;
        q.add(node);
        while (!q.isEmpty()){
            node = q.remove();
            System.out.println(node.e);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return minimum(root);
    }

    private E minimum(Node node) {
        if(node.left == null)
            return node.e;
        return minimum(node.left);
    }

    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return maximum(root);
    }

    private E maximum(Node node) {
        if(node.right == null)
            return node.e;
        return maximum(node.right);
    }

    public E removeMin(){
        root =removeMin(root);
        return minimum();
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node nodeRight = node.right;
//            node.right = null;
            size--;
            return nodeRight;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        root =removeMax(root);
        return maximum();
    }

    private Node removeMax(Node node) {
        if(node.right == null){
            Node nodeLeft = node.left;
            node.left = null;
            size--;
            return nodeLeft;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        if(!contains(e)){
            throw new IllegalArgumentException("删除失败，没有元素"+e);
        }
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node.e.compareTo(e) == 0){
            if (node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size--;
                node = nodeRight;
            }else if (node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                node = nodeLeft;
            }else {
                E e1 = minimum(node.right);
                Node newNode = removeMin(node.right);
                node.right = newNode;
                node.e = e1;
            }
        }else if (node.e.compareTo(e) > 0){
            node.left = remove(node.left,e);
        }else {
            node.right = remove(node.right,e);
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
