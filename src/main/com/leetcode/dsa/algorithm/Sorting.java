package main.com.leetcode.dsa.algorithm;

import java.util.Arrays;

public class Sorting {

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void selectionSort(int[] numbers){
        if(numbers.length <=1)
            return;

        int localMinIndex = 0;
        int localMin;
        for(int i=0; i<numbers.length; i++){
            localMin = numbers[i];
            for(int j=i; j<numbers.length; j++) {
                if (numbers[j] < localMin) {
                    localMin = numbers[j];
                    localMinIndex = j;
                }
            }
            swap(numbers, i, localMinIndex);
        }
    }

    public void bubbleSort(int[] numbers){
        if(numbers.length <=1)
            return;

        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length-i-1; j++){
                if(numbers[j] > numbers[j+1])
                    swap(numbers, j, j+1);
            }
        }
    }

    public void insertionSort(int[] numbers){
        if(numbers.length <=1)
            return;

        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<=i; j++){
                if(numbers[i] < numbers[j]){
                    swap(numbers, i, j);
                }
            }
        }
    }

    public int[] mergeSort(int[] numbers){
        if(numbers.length == 1)
            return numbers;

        int middle = numbers.length % 2 == 0 ? (numbers.length/2)-1  : numbers.length/2;
        int[] left = new int[middle+1];
        int[] right = new int[numbers.length - middle - 1];

        for(int i=0; i<=middle; i++)
            left[i] = numbers[i];

        for(int i=middle+1; i<numbers.length; i++)
            right[i-middle-1] = numbers[i];

        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] mergedSortedArr = new int[left.length + right.length];
        int ptr1 = 0;
        int ptr2 = 0;
        int insertionPtr = 0;

        while(ptr1 < left.length && ptr2 < right.length){
            if(left[ptr1] < right[ptr2])
                mergedSortedArr[insertionPtr++] = left[ptr1++];
            else if(left[ptr1] > right[ptr2])
                mergedSortedArr[insertionPtr++] = right[ptr2++];
            else{
                mergedSortedArr[insertionPtr++] = left[ptr1++];
                mergedSortedArr[insertionPtr++] = right[ptr2++];
            }
        }

        while(ptr1 < left.length){
            mergedSortedArr[insertionPtr++] = left[ptr1++];
        }
        while(ptr2 < right.length){
            mergedSortedArr[insertionPtr++] = right[ptr2++];
        }

        return mergedSortedArr;
    }

    public int[] quickSort(int[] numbers, int left, int right){
        if(left < right) {
            int partitionIndex = shiftArrayByPivot(numbers, left, right);
            quickSort(numbers, left, partitionIndex-1);
            quickSort(numbers, partitionIndex+1, right);
        }

        return numbers;
    }

    public int shiftArrayByPivot(int[] numbers, int left, int right){
        if(numbers.length <= 1)
            return 0;

        int pivotIndex = right;
        for(int i=left; i<pivotIndex; i++){
            if(numbers[i] > numbers[pivotIndex]){
                swap(numbers, i, pivotIndex-1);
                swap(numbers, pivotIndex, pivotIndex-1);
                pivotIndex--;
                i--;
            }
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        Sorting obj = new Sorting();

        int[] arr = {2, 9, 1, 4, 5, 0, -5, 10, 0, 1, 7};
        int[] sortedArr = obj.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(sortedArr));
    }
}
