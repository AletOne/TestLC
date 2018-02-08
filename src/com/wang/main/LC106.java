package com.wang.main;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;
import com.wang.TreeNode;

public class LC106 {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    public static TreeNode buildTree(int rootIndex, int start, int end, int[] inorder, int[] postorder){
        if (start > end || rootIndex < 0){
            return null;
        }
        System.out.println(rootIndex);
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int newIndex = start;
        for (int i = start; i <= end; i++){
            if (inorder[i] == postorder[rootIndex]){
                newIndex = i;
                break;
            }
        }
        
        root.left = buildTree(rootIndex - (end - newIndex) - 1, start, newIndex - 1, inorder, postorder);
        root.right = buildTree(rootIndex - 1, newIndex + 1, end, inorder, postorder);
        return root;
    }
}
