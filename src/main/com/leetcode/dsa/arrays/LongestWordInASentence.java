package main.com.leetcode.dsa.arrays;

//Solved - not sure if optimal solution O(n)
public class LongestWordInASentence {

    /**
     * REGEX for cleaning : "[^\\w\\s]"
     *
     *
     * @param sen
     * @return
     */
    public String longestWord(String sen) {
        String[] listOfWords;
        String largestWord = "";
        String cleanedSen = sen.replaceAll("[^\\w\\s]","");

        listOfWords = cleanedSen.split(" ");
        for(String word : listOfWords){
            if(word.length() > largestWord.length())
                largestWord = word;
        }
        return largestWord;
    }

    public static void main(String[] args) {
        LongestWordInASentence obj = new LongestWordInASentence();
        String sen = "I love dogs avery much";
        System.out.println(obj.longestWord(sen));
    }

}
