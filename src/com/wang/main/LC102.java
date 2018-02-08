package com.wang.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wang.TreeNode;

public class LC102 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (q.peek() != null){
            List<Integer> temp = new ArrayList<>();
            int reCount = 0;
            for (int i = count; i > 0; i--){
            	System.out.println(count);
                TreeNode node = q.remove();
                temp.add(node.val);
                if (node.left != null){
                    q.offer(node.left);
                    reCount++;
                }
                if (node.right != null){
                    q.offer(node.right);
                    reCount++;
                }
            }
            System.out.println(reCount);
            count = reCount;
            result.add(temp);
        }
        return result;
	}
}
