package com.wang.main;
import java.util.*;

public class WordLadderII {

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        
        Map<String, List<String>> tree = new HashMap<>();
        
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        //Set<String> endSet = new HashSet<>();
        
        if (!wordSet.contains(endWord)){
           return result; 
        }
        
        //int level = 1;
        beginSet.add(beginWord);
        visited.add(beginWord);
        
        while (!beginSet.isEmpty()){
            
            
            for (String s : beginSet){
                visited.add(s);
            }
            Set<String> temp = new HashSet<>();
            
            for (String curr : beginSet){
                tree.put(curr, new ArrayList<String>());
                char[] chs = curr.toCharArray();
                for (int i = 0; i < chs.length; i++){
                    for (char c = 'a'; c <= 'z'; c++){
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (!visited.contains(target) && wordSet.contains(target)){
                            tree.get(curr).add(target);
                            temp.add(target);
                            //visited.add(target);
                        }
                    }
                }
            }
            beginSet = temp;
        }
        List<String> now = new ArrayList<>();
        dfs(result, now, tree, beginWord, endWord);
        return result;
    }
    
    public static void dfs(List<List<String>> result, List<String> now, Map<String, List<String>> tree, String currS, String target){
        if (currS == null){
            return;
        }
        if (currS.equals(target)){
            now.add(currS);
            result.add(new ArrayList<>(now));
            now.remove(now.size()-1);
            return;
        }
        now.add(currS);
        List<String> nexts = tree.get(currS);
        for (String next : nexts){
            dfs(result, now, tree, next, target);
        }
        now.remove(now.size()-1);
    }
}
