package kakao2021.internship01;

import java.util.ArrayList;

/*
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 * 
 */

class Solution {
    
	public int solution(String s) {
        s = s.replace("zero", "0");
    	s = s.replace("one", "1");
    	s = s.replace("two", "2");
    	s = s.replace("three", "3");
    	s = s.replace("four", "4");
    	s = s.replace("five", "5");
    	s = s.replace("six", "6");
    	s = s.replace("seven", "7");
    	s = s.replace("eight", "8");
    	s = s.replace("nine", "9");
    	
    	return Integer.parseInt(s);
    }
    
    public int solution2(String s) {
    	String res = "";
    	for (int i = 0; i < s.length(); i++) {
    		
    		if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
    			if (s.charAt(i) == 'z') {
    				res += "0";
    				i += 3;
    			} else if (s.charAt(i) == 'o') {
    				res += "1";
    				i += 2;
    			} else if (s.charAt(i) == 't') {
    				if (s.charAt(i + 1) == 'w') {
    					res += "2";
    					i += 2;
    				} else {
    					res += "3";
    					i += 4;
    				}
    			} else if (s.charAt(i) == 'f') {
    				if (s.charAt(i + 1) == 'o') {
    					res += "4";
    					i += 3;
    				} else {
    					res += "5";
    					i += 3;
    				}
    			} else if (s.charAt(i) == 's') {
    				if (s.charAt(i + 1) == 'i') {
    					res += "6";
    					i += 2;
    				} else {
    					res += "7";
    					i += 4;
    				}
    			} else if (s.charAt(i) == 'e') {
    				res += "8";
    				i += 4;
    			} else {
    				res += "9";
    				i += 3;
    			}
    		} else {
        		res += s.charAt(i);
        	}
    	} 
    	return Integer.parseInt(res);
    }
}