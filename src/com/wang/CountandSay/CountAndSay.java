package com.wang.CountandSay;

public class CountAndSay {
	public static String countandsay(int n){
		if (n == 1){
			return "1";
		}
		String possess = countandsay(n-1);
		System.out.println("n=" + n + "start _-------------");
        String result = "";
        int count = 0;
        String temp = "";
        int i;
        for (i = 0; i < possess.length(); i++){
            if (temp != "" && possess.charAt(i) == temp.charAt(0)){
                temp += possess.charAt(i);
                count++;
            }else if (temp == ""){
                temp += possess.charAt(i);
                count++;
            }else{
                result += String.valueOf(count) + temp.charAt(0) + "";
                temp = possess.charAt(i) + "";
                count = 1;
            }
            System.out.println("temp is " + temp);
            System.out.println("count is " + count);
        }
        System.out.println("temp is " + temp);
        System.out.println("count is " + count);
        if (i == possess.length() && temp != ""){
            result += String.valueOf(count) + temp.charAt(0) + "";
        }
        System.out.println("result is " + result);
        return result;
		
	}
}
