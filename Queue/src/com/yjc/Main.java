package com.yjc;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);

        queue.enqueue(44);
        queue.enqueue(22);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
    }
}
