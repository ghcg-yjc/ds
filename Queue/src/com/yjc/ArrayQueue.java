package com.yjc;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(getSize());
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:Head[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize()-1)
                res.append(",");
        }
        res.append("]Tail");
        return res.toString();
    }
}
