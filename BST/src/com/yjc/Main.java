package com.yjc;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] ints = {5,3,6,8,4,2};
        for (int i = 0; i < ints.length; i++) {
            bst.add(ints[i]);
        }
        bst.preOrder();
//        System.out.println(bst);
        System.out.println("---------------------");
        /*System.out.println(bst.removeMin());
        bst.preOrder();*/
//        System.out.println(bst.removeMax());
        bst.remove(7);
        bst.preOrder();
//        bst.levelOrder();
//        bst.preOrder1();
//        bst.inOrder();
//        System.out.println("---------------------");
//        bst.postOrder();
    }

}
