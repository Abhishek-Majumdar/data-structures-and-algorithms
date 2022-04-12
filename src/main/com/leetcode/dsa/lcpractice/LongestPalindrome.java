package main.com.leetcode.dsa.lcpractice;

import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    public boolean isPalindrome(String toCheck){
        return toCheck.equals((new StringBuilder(toCheck)).reverse().toString());
    }

    public String longestPalindromeInString(String toSearch){
        String result = "";
        String tmpString;

        for(int i=0; i<toSearch.length(); i++){
            for(int j=i+1; j<=toSearch.length(); j++){
                tmpString = toSearch.substring(i,j);
                if(isPalindrome(tmpString) && tmpString.length() > result.length())
                    result = tmpString;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindromeInString("abba"));
    }

}
