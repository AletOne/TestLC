package com.wang.main;

public class InformationMasking {

	public static String numberMasking(String number){
		StringBuilder digits = new StringBuilder();
        int count = 0;
        for (char c : number.toCharArray()){
            if (Character.isDigit(c)){
                digits.append(c);
                count++;
            }
        }
        
        int countryCode = count - 10;
        StringBuilder result = new StringBuilder();
        

        result.append(digits.substring(count-4, count));
        result.insert(0, '-');
        result.insert(0, "***-***");
        
        if (countryCode > 0){
            result.insert(0, '-');
            while (countryCode > 0){
                result.insert(0, '*');
                countryCode--;
            }
            result.insert(0, '+');
        }
        result.insert(0, "P: ");
        return result.toString();
	}
}
