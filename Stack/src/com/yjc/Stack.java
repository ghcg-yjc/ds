package com.yjc;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    E peek();
    void push(E e);
    E pop();
}
