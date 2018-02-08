package com.wang.main;

import java.util.Stack;

public class ExpressionExpand {
	public static String expressionExpand(String s) {
        // write your code here
        Stack<Object> stack = new Stack<>();
        for (char c : s.toCharArray()){
        	System.out.println("char is " + c);
            int number = 0;
            if (Character.isDigit(c)){
            	System.out.println("char is " + c);
                number = number * 10 + (c-'0');
                System.out.println("number is " + number);
            }else if (c == '['){
            	System.out.println("number is " + number);
                stack.push(number);
                number = 0;
            }else if (c == ']'){
                StringBuilder sb = new StringBuilder();
                while (!stack.empty() && (stack.peek() instanceof String)){
                    sb.insert(0, String.valueOf(stack.pop()));
                }
                System.out.println("String is " + sb.toString());
                Integer count = (Integer) stack.pop();
                System.out.println("count is " + count);
                for (int i = 0; i < count; i++){
                    stack.push(sb.toString());
                }
            }else{
                stack.push(String.valueOf(c));
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.insert(0, String.valueOf(stack.pop()));
        }
        return result.toString();
    }
}
