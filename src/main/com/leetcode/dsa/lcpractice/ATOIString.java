package main.com.leetcode.dsa.lcpractice;

//https://leetcode.com/problems/string-to-integer-atoi/
public class ATOIString {

    public boolean isParseableInteger(String toParse){
        try{
            Integer.parseInt(toParse);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public int formNumberFromCharList(StringBuilder charList){
        long number = 0;
        boolean isNegative = false;

        if(charList.indexOf("-") != -1 && charList.indexOf("+") != -1)
            return 0;

        if(charList.indexOf("-") > 0 || charList.indexOf("+") > 0)
            return 0;


        for(int i=0; i<charList.length(); i++){
            if(charList.charAt(i) == '+')
                continue;
            else if(charList.charAt(i) == '-'){
                isNegative = true;
                continue;
            }

            number += Integer.parseInt(String.valueOf(charList.charAt(i))) * Math.pow(10, charList.length()-i-1);
            if(number > Integer.MAX_VALUE)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isNegative ? Math.negateExact((int)number) : (int)number;
    }

    public int convertStringToInteger(String str){
        if(str == null || str.length() == 0)
            return 0;

        int convertedNum = 0;
        char[] strArr = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<strArr.length; i++){
            if(strArr[i] == ' ')
                continue;

            if(strArr[i] == '-' || strArr[i] == '+') {
                builder.append(strArr[i]);
                continue;
            }

            if(! isParseableInteger(String.valueOf(strArr[i])))
                break;
            else
                builder.append(strArr[i]);
        }

        convertedNum = formNumberFromCharList(builder);
        return convertedNum;
    }

    public static void main(String[] args) {
        ATOIString obj = new ATOIString();
        System.out.println(obj.convertStringToInteger("00000-42a1234"));
    }

}
