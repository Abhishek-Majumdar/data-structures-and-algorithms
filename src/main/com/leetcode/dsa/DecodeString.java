package main.com.leetcode.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodeString {

    public boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public String decodeString(String toDecode){
        if(toDecode == null || toDecode.length() == 0 || toDecode.trim().length() == 0)
            return "";

        String decoded = "";
        List<String> charStack = new ArrayList<>();
        StringBuilder currStringBuilder;
        String currString = null;
        String currentChar;

        for(int i=0; i<toDecode.length(); i++){
            currentChar = String.valueOf(toDecode.charAt(i));
            if(! currentChar.equals("]")){
                charStack.add(currentChar);
            }
            else{
                currStringBuilder = new StringBuilder();
                while(! currentChar.equals("[")){
                    currentChar = charStack.remove(charStack.size()-1);
                    currStringBuilder.append(currentChar);
                }
                currStringBuilder.deleteCharAt(currStringBuilder.length()-1);

                if(isInteger(charStack.get(charStack.size()-1))){
                    currStringBuilder.reverse();
                    currString = new String(new char[Integer.parseInt(charStack.get(charStack.size()-1))])
                            .replace("\0", currStringBuilder.toString());
                }
                charStack.remove(charStack.size()-1);
                if(currString != null) {
                    charStack.add(currString);
                    currString = null;
                    currStringBuilder.delete(0, currStringBuilder.length()-1);
                }
            }
        }

        decoded = String.join("", charStack);
        return decoded;
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String toDecode = "3[a]4[c]2[a2[e]]fg";

        System.out.println(obj.decodeString(toDecode));
    }

}
