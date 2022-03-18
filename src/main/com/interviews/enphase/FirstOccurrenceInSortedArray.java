package main.com.interviews.enphase;

import java.util.HashMap;
import java.util.Map;

public class FirstOccurrenceInSortedArray {

    public int getFirstOccurrenceOfElementUsingBSearch(int[] arr, int value){

        int start = 0;
        int end = arr.length-1;
        int mid;
        int result = -1;

        while(start <= end){
            mid = (start+end)/2;

            if(value > arr[mid])
                start = mid + 1;
            else if(value < arr[mid])
                end = mid-1;
            else{
                result = mid;
                end = mid-1;
            }
        }
        return result;
    }

    public int getDuplicateElement(int[] arr){
        int index = 0;
        Map<Integer, Integer> elements = new HashMap<>();

        for(int i =0; i < arr.length; i++){
            if(elements.containsKey(arr[i]))
                return elements.get(arr[i]);
            else
                elements.put(arr[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        FirstOccurrenceInSortedArray obj = new FirstOccurrenceInSortedArray();
        int[] arr = {1,2,2,3,4,5,5,6,8,9};

        System.out.println(obj.getFirstOccurrenceOfElementUsingBSearch(arr, 2));
    }
}
