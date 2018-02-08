package com.wang.main;
import java.util.*;

public class LC128 {
	 public static int longestConsecutive(int[] nums) {
	        int max = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        if (nums.length == 0){
	            return 0;
	        }
	        
	        for (int i = 0; i < nums.length; i++){
	            int curr = nums[i];
	            if (map.containsKey(curr)){
	                continue;
	            }
	            int left = map.containsKey(curr-1) ? map.get(curr-1) : 0;
	            int right = map.containsKey(curr+1) ? map.get(curr+1) : 0;
	            int sum = left + right + 1;
	            System.out.println("curr : " + curr);
	            System.out.println("left :" + left);
	            System.out.println("right : " + right);
	            System.out.println("sum : " + sum);
	            map.put(curr, sum);
	            if (map.containsKey(curr-1)){
	                map.put(curr-1, sum);
	            }
	            if (map.containsKey(curr+1)){
	                map.put(curr+1, sum);
	            }
	            max = Math.max(max, sum);
	        }
	        return max;
	    }
}
