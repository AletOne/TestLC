package com.wang.main;

import java.sql.SQLClientInfoException;
import java.util.Stack;

public class LC224 {
	public static int calculate(String s) {
        s = s.trim();
        if (s.length() == 0){
            return 0;
        }
        
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        char[] ca = s.toCharArray();
        
        int i = 0;
        while (i < ca.length){
            if (ca[i] >= '0' && ca[i] <= '9'){
                StringBuilder sb = new StringBuilder();
                while ( i < ca.length && ca[i] >= '0' && ca[i] <= '9'){
                    sb.append(ca[i]);
                    i++;
                    //System.out.println(i);
                }
                s2.push(sb.toString());
            }else if (ca[i] == '('){
                s1.push(ca[i] + "");
                //System.out.println("s1 peek is " + s1.peek());
                i++;
            }else if (ca[i] == '+' || ca[i] == '-'){
                if(s1.empty()){
                    s1.push(ca[i] + "");
                }else{
                	System.out.println(ca[i]);
                    while (!s1.empty() && 
                           (s1.peek().equals("+") || s1.peek().equals("-"))){
                    	System.out.println(s1.peek());
                    	String top = s1.pop();
                        s2.push(top);
                        
                    }
                    s1.push(ca[i] + "");
                    i++;
                }
            }else if (ca[i] == ')'){
            	String peek = s1.peek();
            	//System.out.println("peek is " + peek);
            	//System.out.println(peek.equals("("));
                while (!peek.equals("(")){
                	//System.out.println("12");
                    s2.push(s1.pop());
                    peek = s1.peek();
                }
                s1.pop();
                i++;
            }else{
                i++;
            }
            
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        
        System.out.println("expression is =========");
        while (!s2.empty()){
        	System.out.print(s2.peek() + " ");
            s1.push(s2.pop());
        }
        System.out.println("------------");
        
        Stack<Integer> res = new Stack<>();
    
        while (!s1.empty()){
            String curr = s1.pop();
            System.out.println("curr string is " + curr);
            if (curr.equals("+")){
                int b = res.pop();
                int a = res.pop();
                res.push(a+b);
            }else if (curr.equals("-")){
                int b = res.pop();
                int a = res.pop();
                res.push(a-b);
            }else{
                res.push(Integer.valueOf(curr));
            }
        }
        return res.pop();
    }
}
