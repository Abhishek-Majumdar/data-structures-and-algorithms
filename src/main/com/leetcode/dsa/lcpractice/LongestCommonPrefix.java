package main.com.leetcode.dsa.lcpractice;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public int minLengthInStringArray(String[] arr){
        int minLength = Integer.MAX_VALUE;

        for(String element : arr){
            minLength = Math.min(element.length(), minLength);
        }

        return minLength;
    }

    public String getLongestPrefix(String[] arr){
        String longestCommonPrefix = "";
        int minStringLength = minLengthInStringArray(arr);
        StringBuilder commonPrefix = new StringBuilder();
        Set<Character> characterSet;

        for (int i = 0; i < minStringLength; i++) {
            characterSet = new HashSet<>();
            for(String element : arr) {
                characterSet.add(element.charAt(i));
            }
            if(characterSet.size() == 1)
                commonPrefix.append(characterSet.toArray()[0]);
            else
                break;
        }

        longestCommonPrefix = commonPrefix.toString();
        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = new String[]{"dog","racecar","car"};


        System.out.println(obj.getLongestPrefix(strs));
    }

}
