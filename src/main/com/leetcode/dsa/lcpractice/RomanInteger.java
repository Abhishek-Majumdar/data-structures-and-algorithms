package main.com.leetcode.dsa.lcpractice;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

    private final Map<Character, Integer> charToNumeral = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    public int convertRomanToInteger(String romanNumeral){
        int number = 0;

        for(int i = 0; i < romanNumeral.length(); i++) {
            if (i != romanNumeral.length() - 1) {
                if (romanNumeral.charAt(i) == 'I' && (romanNumeral.charAt(i + 1) == 'V' || romanNumeral.charAt(i + 1) == 'X')){
                    number -= charToNumeral.get('I');
                    continue;
                }
                else if (romanNumeral.charAt(i) == 'X' && (romanNumeral.charAt(i + 1) == 'L' || romanNumeral.charAt(i + 1) == 'C')){
                    number -= charToNumeral.get('X');
                    continue;
                }
                else if (romanNumeral.charAt(i) == 'C' && (romanNumeral.charAt(i + 1) == 'D' || romanNumeral.charAt(i + 1) == 'M')){
                    number -= charToNumeral.get('C');
                    continue;
                }
            }
            number += charToNumeral.get(romanNumeral.charAt(i));
        }
        return number;
    }

    public static void main(String[] args) {
        RomanInteger obj = new RomanInteger();
        System.out.println(obj.convertRomanToInteger("XXVII"));
    }

}
