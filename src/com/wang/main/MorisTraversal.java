package com.wang.main;

import com.wang.TreeNode;

public class MorisTraversal {

	public static void morisTraversal(TreeNode root){
		TreeNode temp = root;
		TreeNode morisTemp = null;
		
		
		while (temp != null){
			morisTemp = temp;
			if (temp.left != null){
				morisTemp = temp.left;
			
				while (morisTemp.right != null && morisTemp.right != temp){
					morisTemp = morisTemp.right;
				}
				if (morisTemp.right == null){
					morisTemp.right = temp;
					//System.out.println(temp.val); preOrder
					temp = temp.left;
				}
				if (morisTemp.right == temp){
					morisTemp.right = null;
					//System.out.println(temp.val); inOrder
					//if (pre != null && pre.val >= temp.val){
					//	if (first == null){
					//		first = pre;
					//	}
					//	second = temp;
					//}
					//pre = temp;
					temp = temp.right;
				}
			}else{
				System.out.println(temp.val);
				//if (pre != null && pre.val >= temp.val){
				//	if (first == null){
				//		first = pre;
				//	}
				//	second = temp;
				//}
				//pre = temp;
				temp = temp.right;
			}
		}
	}
}
