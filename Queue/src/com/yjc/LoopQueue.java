package com.yjc;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        int next = (tail + 1) % data.length;
        if (next == front) {
            System.out.println("循环队列满，不可添加。。。");
            return;
        }
        data[tail] = e;
        tail = next;
        size++;
    }

    @Override
    public E dequeue() {
        E e;
        if (!isEmpty()) {
            e = data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            size--;
        } else {
            System.out.println("循环队列为空，不可出队列。。。");
            throw new ArrayIndexOutOfBoundsException("数组空，没有元素出队");
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("数组空，队列没有元素");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue:size=%d,capacity=%d. Front[", size, getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (i != tail - 1)
                res.append(",");
        }
        res.append("]Tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(6);
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);

        loopQueue.enqueue(11);
        System.out.println(loopQueue);

        loopQueue.enqueue(22);
        System.out.println(loopQueue);

        System.out.println(loopQueue.getFront());

        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.enqueue(33);
        System.out.println(loopQueue);
    }
}
