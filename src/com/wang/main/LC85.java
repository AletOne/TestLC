package com.wang.main;

public class LC85 {

	public static int maximalRectangle(char[][] matrix){
		if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        for (int i = 0; i < n; i++){
            height[i] = (matrix[0][i] - '0');
        }
        
        int result = largest(height);
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j] += 1;
                }
            }
            result = Math.max(result, largest(height));
        }
        return result;
	}
	
	public static int largest(int[] height){
        int[] lessFromLeft = new int[height.length];
        int[] lessFromRight = new int[height.length];
        int max = 0;
        lessFromLeft[0] = -1;
        lessFromRight[height.length-1] = height.length;
        
        for (int i = 1; i < height.length; i++){
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        
        for (int i = height.length - 2; i >= 0; i--){
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        
        for (int i = 0; i < height.length; i++){
            max = Math.max(max, (lessFromRight[i] - lessFromLeft[i] - 1) * height[i]);
        }
        return max;
    }
}
