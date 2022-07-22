package main.com.leetcode.dsa.lcpractice;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String str) {
        String largestString = "";

        if(str.length() == 1)
            return 1;

        char[] arr = str.toCharArray();
        StringBuilder stringBuffer = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            if((stringBuffer.indexOf(String.valueOf(arr[i])) == -1)){
                stringBuffer.append(arr[i]);
            }
            else{
                stringBuffer.delete(0, stringBuffer.indexOf(String.valueOf(arr[i])) + 1);
                stringBuffer.append(arr[i]);
            }
            largestString = stringBuffer.length() > largestString.length() ?
                    stringBuffer.toString() : largestString;
        }

        return largestString.length();
    }

    public static void main(String[] args) {
        LongestNonRepeatingSubstring subStr = new LongestNonRepeatingSubstring();
        System.out.println(subStr.lengthOfLongestSubstring("abcabcdefbbd"));
    }
}
