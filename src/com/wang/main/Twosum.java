package com.wang.main;

import java.util.HashMap;
import java.util.Map;

public class Twosum {
	 public static int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++){
	            map.put(nums[i], i);
	        }
	        
	        for (int i = 0; i < nums.length; i++){
	            int key = target - nums[i];
	            System.out.println(key);
	            if (map.containsKey(key)){
	                return new int[]{i, map.get(key)};
	            }
	        }
	        return new int[]{};
	    }
}
