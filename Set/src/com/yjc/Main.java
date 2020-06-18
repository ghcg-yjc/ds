package com.yjc;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*BSTSet<String> bstSet = new BSTSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        FileOperation.readFile("Set/pride-and-prejudice.txt",arrayList);
        System.out.println("Pride and Prejudice:");
        for (String word:arrayList) {
            bstSet.add(word);
        }
        System.out.println("Total words:"+arrayList.size());
        System.out.println("Total different words:"+bstSet.getSize());

        ArrayList<String> arrayList1 = new ArrayList<>();
        BSTSet<String> bstSet1 = new BSTSet<>();
        FileOperation.readFile("Set/a-tale-of-two-cities.txt",arrayList1);
        System.out.println("A Tale of Two Cities:");
        for (String word:arrayList1) {
            bstSet1.add(word);
        }
        System.out.println("Total words:"+arrayList1.size());
        System.out.println("Total different words:"+bstSet1.getSize());*/

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        FileOperation.readFile("Set/pride-and-prejudice.txt",arrayList);
        System.out.println("Pride and Prejudice:");
        for (String word:arrayList) {
            linkedListSet.add(word);
        }
        System.out.println("Total words:"+arrayList.size());
        System.out.println("Total different words:"+linkedListSet.getSize());

    }
}
