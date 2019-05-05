//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

package com.vpr.leetcode;

class Solution {
    public String minWindow(String word, String subString) {

    	
    	int[] subStringMap = new int[128], wordMap = new int[128];
		int subStringLength = subString.length(), wordLength = word.length(), currentLength = 0, left = 0, windowLength = Integer.MAX_VALUE, begIndex = 0;
    	
    	
    	
    	for(int i = 0; i < subStringLength; i++) {
    		subStringMap[subString.charAt(i)]++;
    	}
    	
    	for(int right = 0; right < wordLength; right++) {
    		wordMap[word.charAt(right)]++;
    		
    		if(wordMap[word.charAt(right)] <= subStringMap[word.charAt(right)]) {
    			currentLength++;
    		}
    		
    		while(currentLength == subStringLength) {
    			
    			if(right + 1 - left < windowLength) {
    				windowLength = right + 1 - left;
    				begIndex = left;
    			}
    			
    			wordMap[word.charAt(left)] -- ;
    			
    			if(wordMap[word.charAt(left)] < subStringMap[word.charAt(left)]) {
    				currentLength--;
    			}
    			
    			left++;
    		}
    	}
    	
    	
    	return windowLength == Integer.MAX_VALUE ? "" : word.substring(begIndex, begIndex + windowLength);
    }
}



public class WindowSubstring {
	public static void main(String args[]) {
		Solution solution = new Solution();

		//String S = "bba", T = "ab";
		//String S = "ab", T = "b";
		//String S = "ab", T = "a";
		//String S = "A", T = "AA";
		//String S = "cabefgecdaecf", T = "cae";

		String S = "DAOBECODEBANC", T = "ABC";

		System.out.println(solution.minWindow(S, T));
	}
}
