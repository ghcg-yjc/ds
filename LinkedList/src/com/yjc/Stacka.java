package com.yjc;

public interface Stacka<E> {
    int getSize();
    boolean isEmpty();
    E peek();
    void push(E e);
    E pop();
}
