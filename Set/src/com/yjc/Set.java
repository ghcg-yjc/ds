package com.yjc;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
    boolean contains(E e);
}
