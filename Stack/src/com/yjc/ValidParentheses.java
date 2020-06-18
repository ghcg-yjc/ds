package com.yjc;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<>();
        Scanner console = new Scanner(System.in);
        System.out.println(stack);
        System.out.println(stack.getSize()+","+stack.getCapacity());
        String s = console.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
                System.out.println(stack);
                System.out.println(stack.getSize()+","+stack.getCapacity());
            }else if(c == ']' && stack.peek() == '['){
                stack.pop();
            }else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(c == ')' && stack.peek() == '('){
                stack.pop();
            }else {
                System.out.println("括号不匹配。。。");
                return;
            }
        }
    }
}
