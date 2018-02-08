package com.wang.main;

public class LongestKthSubstring {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int[] map = new int[256];
        int result = 0;
        int j = 0;
        int count = 0;
        
        
        for (int i = 0; i < s.length(); i++){
            while (j < s.length() && count < k){
                if (map[s.charAt(j)] == 0){
                    count++;
                }
                map[s.charAt(j)]++;
                j++;
            }
            result = Math.max(result, j-i);
            System.out.println(i + "  " + j + "  " + count + "  " + result);
            
            System.out.println("");
            map[s.charAt(i)]--;
            if (map[s.charAt(i)] == 0){
                count--;
            }
            
        }
        return result;
    }
}
