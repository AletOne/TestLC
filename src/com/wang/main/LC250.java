package com.wang.main;

import com.wang.TreeNode;

public class LC250 {
	public static int countUnivalSubtrees(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        
        int[] count = {0};
        boolean left = dfs(root.left, count);
        boolean right = dfs(root.left, count);
        if (left){
            count[0]++;
        }
        if (right){
            count[0]++;
        }
        
    
        return count[0];
    }
    
    private static boolean dfs(TreeNode node, int[] count){
        if(node == null){
            return false;
        }
        boolean left = dfs(node.left, count);
        boolean right = dfs(node.right, count);
        if (left){
            count[0]++;
        }
        if (right){
            count[0]++;
        }
        
        System.out.println("node.val is " + node.val + "  count is " + count[0]);
        System.out.println("left  " + left + "  right   " + right);
        if (left && !right){
            return node.val == node.left.val;
        }else if (!left && right){
            return node.val == node.right.val;
        }else if (left && right){
            if (node.val == node.left.val && node.val == node.right.val){
                return true;
            }else{
                return false;
            }
        }else{
            if (node.left == null && node.right == null){
                return true;
            }else{
                return false;
            }
        }
    }
}
