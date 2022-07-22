package main.com.leetcode.dsa.lcpractice;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        final int alphabetCount = 26;
        final int asciiOffset = 64;

        int columnIndex = 0;
        int titleLength = columnTitle.length() -1;
        int tmp;

        for(int i = 0; i <= titleLength; i++){
            tmp = columnTitle.charAt(i) - asciiOffset;
            columnIndex += Math.pow(alphabetCount, titleLength-i) * tmp;
        }

        return columnIndex;
    }

    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnNumber.titleToNumber("ZY"));
    }
}
