package main.com.interviews;

public class Microsoft {

    public static int solution(String S) {
        // write your code in Java SE 8
        int result = Integer.MIN_VALUE;
        String[] maxWordSentence;
        if(S.length() == 0)
            return 0;

        String[] sentences = S.split("[.!?]");
        for(String sentence : sentences){
            maxWordSentence = sentence.split(" ");
            result = Math.max(result, maxWordSentence.length);
        }

        result = result > 0 ? result : 0;

        return result;
    }

    public static void main(String[] args) {

        System.out.println(Microsoft.solution("We test coders. Give us a try?"));

    }
}
