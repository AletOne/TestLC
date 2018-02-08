package com.wang.main;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {

	public static List<String> fullJustify(String[] words, int maxWidth){
		 List<String> line = new ArrayList<>();
	        
	        int index = 0;
	        while (index < words.length){
	            int count = words[index].length();
	            int last = index + 1;
	            while (last < words.length){
	                if (count + words[last].length() + 1 > maxWidth){
	                    break;
	                }
	                count += words[last].length() + 1;
	                last++;
	                
	            }
	            
	            StringBuilder sb = new StringBuilder();
	            int spaceNumber = last - index - 1;
	            System.out.println("spaceNumber = " + spaceNumber);
	            System.out.println("count = " + count);
	            
	            //Last line or only one word, left-justified;
	            if (last == words.length || spaceNumber == 0){
	                for (int i = index; i < last; i++){
	                    sb.append(words[i] + " ");
	                }
	                sb.deleteCharAt(sb.length() - 1);
	                for (int i = sb.length(); i < maxWidth; i++){
	                    sb.append(" ");
	                }
	            }else{
	                // middle lines
	                int extraSpace = maxWidth - count + spaceNumber;
	                int everySpace = extraSpace / spaceNumber;
	                int extraFrontSpace = extraSpace % spaceNumber;
	                
	                System.out.println("extraSpacec = " + extraSpace);
	                System.out.println("everySpace = " + everySpace);
	                System.out.println("extraFrontSpace = " + extraFrontSpace);
	                
	                for (int i = index; i < last; i++){
	                    sb.append(words[i]);
	                    if (i < last - 1){
	                       for (int j = 0; j < everySpace + (i - index < extraFrontSpace ? 1 : 0); j++){
	                        sb.append(" ");
	                       } 
	                    }
	                    
	                    
	                }
	            }
	            line.add(sb.toString());
	            index = last;
	        }
	        return line;
	}
}
