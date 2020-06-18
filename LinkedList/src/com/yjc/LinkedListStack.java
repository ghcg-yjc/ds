package com.yjc;

public class LinkedListStack<E> implements Stacka<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedListStack:siz =%d.top{",getSize()));
        for (int i = 0; i < getSize(); i++) {
            res.append(linkedList.get(i));
            if(i != getSize()-1)
                res.append(",");
        }
        res.append("}tail");
        return res.toString();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        stack.push(12);
        System.out.println(stack);
    }
}
