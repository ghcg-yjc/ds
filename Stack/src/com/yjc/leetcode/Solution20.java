package com.yjc.leetcode;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else{
                if (stack.isEmpty())
                    return false;
                Character pop = stack.pop();
                if(c == ']' && pop != '['){
                    return false;
                }
                if(c == '}' && pop != '{'){
                    return false;
                }
                if(c == ')' && pop != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
