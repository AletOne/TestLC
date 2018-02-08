package com.wang.test;

import java.util.ArrayList;
import java.util.List;

import com.wang.TreeNode;
import com.wang.CountandSay.CountAndSay;
import com.wang.main.ExpressionExpand;
import com.wang.main.FullJustify;
import com.wang.main.InformationMasking;
import com.wang.main.LC102;
import com.wang.main.LC106;
import com.wang.main.LC128;
import com.wang.main.LC130;
import com.wang.main.LC224;
import com.wang.main.LC250;
import com.wang.main.LC300;
import com.wang.main.LC85;
import com.wang.main.LongestKthSubstring;
import com.wang.main.TestLC214;
import com.wang.main.WordLadder;
import com.wang.main.WordLadderII;

import junit.framework.TestCase;

public class TestLeetCode extends TestCase{
	public void testCountAndSay(){
		String result = CountAndSay.countandsay(4);
		System.out.println(result);
	}
	
	public void testFullJustify(){
		String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		int maxWidth = 30;
		List<String> result = FullJustify.fullJustify(words, maxWidth);
		System.out.println(result);
	}
	
	public void testLargestIn85(){
		int[] height = {2, 4, 2, 2, 0};
		int result = LC85.largest(height);
		System.out.println(result);
	}
	
	public void testLC85(){
		char[][] matrix = {{'1', '0', '1', '0', '0'},
						   {'1', '0', '1', '1', '1'},
						   {'1', '1', '1', '1', '1'},
						   {'1', '0', '0', '1', '0'}};
		int result = LC85.maximalRectangle(matrix);
		System.out.println(result);
	}
	
	public void testLC102(){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		TreeNode node = root.right;
		node.left = new TreeNode(15);
		node.right = new TreeNode(7);
		List<List<Integer>> result = LC102.levelOrder(root);
		System.out.println(result);
	}
	
	public void testLC106(){
		int[] inorder = {1, 2, 3, 4};
		int[] postorder = {3, 4, 2, 1};
		LC106.buildTree(inorder, postorder);		
	}
	
	public void testWordLadder(){
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(WordLadder.ladderLength(beginWord, endWord, wordList));
	}
	
	public void testWordLadderII(){
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(WordLadderII.findLadders(beginWord, endWord, wordList));
	}
	
	public void testLc128(){
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		System.out.println("result : " + LC128.longestConsecutive(nums));
	}
	
	public void testLC130(){
		char[][] board = {{'X','X','X','X'},
						  {'X','0','0','X'},
						  {'X','X','0','X'},
						  {'X','0','X','X'}};
		LC130.solve(board);
		for (int i = 0; i < board.length; i++){
        	System.out.println(String.valueOf(board[i]));
        }
	}
	
	public void testLC300(){
		int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
		LC300.lengthOfLIS(nums);
	}
	
	public void testLC214(){
		String s = "aacecaaa";
		System.out.println(TestLC214.shortestPalindrome(s));
	}
	
	public void testLC224(){
		String s = " 2-1 + 2 ";
		System.out.println(LC224.calculate(s));
	}
	
	public void testLC250(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(1);
		System.out.println(LC250.countUnivalSubtrees(root));
	}
	
	public void testLongestKthSubstring(){
		LongestKthSubstring.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh",
				16);
	}
	
	public void testExpressionExpand(){
		System.out.println(ExpressionExpand.expressionExpand("3[abc]"));
	}
	
	public void testNumberMasking(){
		String number = "+1 (333) 408 2767";
		System.out.println(InformationMasking.numberMasking(number));
	}
}
