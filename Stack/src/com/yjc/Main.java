package com.yjc;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(20);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        stack.push(23);
        stack.push(25);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
    }
}
