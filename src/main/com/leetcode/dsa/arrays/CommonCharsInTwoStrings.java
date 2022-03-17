package main.com.leetcode.dsa.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonCharsInTwoStrings {

    public String commonElements(String string1, String string2){
        return Arrays.stream(string1.split("")).filter(string2::contains).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "String12345678";
        CommonCharsInTwoStrings obj = new CommonCharsInTwoStrings();
        System.out.println(obj.commonElements(str1, str2));
    }

}
