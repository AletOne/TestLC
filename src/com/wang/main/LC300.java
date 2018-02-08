package com.wang.main;

public class LC300 {
	public static int lengthOfLIS(int[] nums) {
//      int[] dp = new int[nums.length];
     
//      for (int i = 0; i < nums.length; i++){
//          dp[i] = 1;
//      }
     
     
     // for (int j = 1; j < nums.length; j++){
     //     for (int i = 0; i < j; i++){
     //         if (nums[i] < nums[j]){
     //             dp[j] = Math.max(dp[j], dp[i] + 1);
     //         }
     //     }
     // }
     
     if (nums.length == 0){
         return 0;
     }
     
     int len = 0;
     int[] tail = new int[nums.length];
     tail[0] = nums[0];
     
     for (int i = 1; i < nums.length; i++){
         if (nums[i] <= tail[0]){
             tail[0] = nums[i];
         }else if (nums[i] >= tail[len]){
             tail[++len] = nums[i];
         }else{
             int l = 0;
             int h = len;
             int mid = 0;
             while (l <= h){
                 mid = l + (h - l) / 2;
                 if (tail[mid] == nums[i]){
                     break;
                 }else if (tail[mid] < nums[i]){
                     l = mid+1;
                 }else{
                     h = mid-1;
                 }
             }
             
             if (tail[mid] < nums[i]){
            	 tail[mid+1] = nums[i];
             }else{
            	 tail[mid] = nums[i];
             }      
         }
         
         System.out.println("--------------------------");
         for (int j = 0; j < tail.length; j++){
        	 System.out.print(tail[j]);
         }
         System.out.println("");
         System.out.println("--------------------------");
     }
     
     return ++len;
     // int max = 0;
     // for (int i = 0; i < nums.length; i++){
     //     max = Math.max(max, dp[i]);
     // }
     // return max;
 }
}
