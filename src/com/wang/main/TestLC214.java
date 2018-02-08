package com.wang.main;

public class TestLC214 {
	public static String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1){
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        int low = n/2 - 1;
        int high = n/2 + 1;
        
        while (low < 0 || high > n-1){
            if (sb.charAt(low) == sb.charAt(high)){
                low--;
                high++;
            }else{
                sb.insert(high, sb.charAt(low));
            }
            System.out.println(sb);
        }
        
        if (low < 0 && high < n){
            while (high < n){
                sb.insert(0, sb.charAt(high++));
                System.out.println(sb);
            }
        }
        
        if (low >= 0 && high > n-1){
            while (low >= 0){
                sb.append(sb.charAt(low--));
                System.out.println(sb);
            }
        }
        
        return sb.toString();
    }
}
