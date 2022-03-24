package main.com.leetcode.dsa.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    /**
     * Two pointer approach, compare indices and
     * move pointer after inserting smaller element.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int[] mergedArray = new int[arr1.length + arr2.length]; //O(1)

        int arr1Ptr = 0;
        int arr2Ptr = 0;
        int insertionPtr = 0;

        while(arr1Ptr < arr1.length && arr2Ptr < arr2.length){  //O(n+m)    Worst case
            if(arr1[arr1Ptr] < arr2[arr2Ptr]){                  //O(1)
                mergedArray[insertionPtr] = arr1[arr1Ptr];      //O(1)
                arr1Ptr++;
            }
            else if(arr1[arr1Ptr] > arr2[arr2Ptr]){
                mergedArray[insertionPtr] = arr2[arr2Ptr];
                arr2Ptr++;
            }
            else{
                mergedArray[insertionPtr++] = arr1[arr1Ptr];
                mergedArray[insertionPtr] = arr2[arr2Ptr];
                arr1Ptr++;
                arr2Ptr++;
            }
            insertionPtr++;
        }

        while(arr1Ptr < arr1.length){
            mergedArray[insertionPtr++] = arr1[arr1Ptr++];
        }
        while(arr2Ptr < arr2.length){
            mergedArray[insertionPtr++] = arr2[arr2Ptr++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeObj = new MergeSortedArrays();

        int[] arr1 = {-1,2,4,7,9};
        int[] arr2 = {-5,2,8,12};

        System.out.println(Arrays.toString(mergeObj.mergeSortedArrays(arr1, arr2)));
    }
}
