package com.wang.main;

import java.util.PriorityQueue;

public class DataStreamMedian {
	public static int[] medianII(int[] nums) {
        // write your code here
        
        int[] result = new int[nums.length];
        if (nums.length == 0){
            return result;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int median = nums[0];
        result[0] = median;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > median){
                minHeap.offer(nums[i]);
            }else{
                maxHeap.offer(nums[i]);
            }
            
            while (minHeap.size() >= maxHeap.size() + 2){
                maxHeap.offer(median);
                median = minHeap.poll();
            }
            
            while (minHeap.size() >= maxHeap.size() + 1){
                minHeap.offer(median);
                median = maxHeap.poll();
            }
            
            result[i] = median;
        }
        
        return result;
    }
}
