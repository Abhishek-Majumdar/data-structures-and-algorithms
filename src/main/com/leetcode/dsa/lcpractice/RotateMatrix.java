package main.com.leetcode.dsa.lcpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RotateMatrix {

    public int[][] convertListToMatrix(List<List<Integer>> matrixList){
        if(matrixList.isEmpty())
            return new int[0][0];

        if(matrixList.get(0).isEmpty())
            return new int[0][0];

        int[][] matrix = new int[matrixList.size()][matrixList.get(0).size()];
        int rowCounter = 0;
        int colCounter = 0;

        for(List<Integer> rowList : matrixList){
            for(int num : rowList){
                   matrix[rowCounter][colCounter++] = num;
            }
            colCounter = 0;
            rowCounter++;
        }
        return matrix;
    }


    /**
     * Rotates a given matrix by 180 degrees
     * anti-clockwise
     *
     * @param arrToRotate matrix(2-D array) to rotate
     * @return copy of rotated matrix
     */
    public int[][] rotatedMatrix(int[][] arrToRotate){
        if(arrToRotate.length == 0)
            return arrToRotate;

        if(arrToRotate[0].length == 0)
            return arrToRotate;

        int[][] rotatedMatrix = new int[arrToRotate.length][arrToRotate[0].length];
        int numberOfRows = rotatedMatrix.length;
        int numberOfCols = rotatedMatrix[0].length;
        List<List<Integer>> matrixList = new ArrayList<>();
        List<Integer> tempRowList;

        for(int i=numberOfRows-1; i>=0; i--){
            tempRowList = new ArrayList<>();
            for(int j=numberOfCols-1; j>=0; j--){
                tempRowList.add(arrToRotate[i][j]);
            }
            matrixList.add(tempRowList);
        }

        return this.convertListToMatrix(matrixList);
    }

    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        int[][] arrToRotate = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] rotatedArr = obj.rotatedMatrix(arrToRotate);
        System.out.println(Arrays.deepToString(rotatedArr));
    }

}
