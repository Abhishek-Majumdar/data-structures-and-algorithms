package main.com.leetcode.dsa.algorithm;

public class Searching {

    public int binarySearch(int[] arrToSearch, int valToFind){
        int foundIndex = -1;
        if(arrToSearch.length == 0)
            return -1;

        int start = 0;
        int end = arrToSearch.length-1;
        int mid;

        for(int i=start; i<=end; i++){
            mid = (start+end)/2;
            if(valToFind > arrToSearch[mid])
                start = mid + 1;
            else if(valToFind < arrToSearch[mid])
                end = mid - 1;
            else
                return mid;
        }

        return foundIndex;
    }

    public static void main(String[] args) {
        Searching obj = new Searching();

        int[] arr = {1, 2, 5, 7, 7, 8, 20};
        System.out.println(obj.binarySearch(arr, 20));
    }

}
