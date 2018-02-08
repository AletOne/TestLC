package com.wang.main;

import java.util.Queue;
import java.util.*;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int length = 1;
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            
            Set<String> temp = new HashSet<>();
            
            for (String word : beginSet){
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++){
                	char old = chs[i];
                    for (char ch = 'a'; ch < 'z'; ch++){
                        
                        chs[i] = ch;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)){
                            length++;
                            System.out.println("final :" + length);
                            return length;
                        }
                        
                        if (!visited.contains(target) && wordList.contains(target)){
                        	System.out.println(target);
                            visited.add(target);
                            temp.add(target);
                        }
                        
                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
            length++;
            System.out.println(length);
            
        }
        return 0;
    }
}
