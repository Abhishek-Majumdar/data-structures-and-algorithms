package main.com.leetcode.dsa.lcpractice;

import main.com.leetcode.dsa.arrays.MergeSortedArrays;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfSortedArrays {

    public double medianOfSortedArrays(int[] nums1, int[] nums2){
        double median = 0.0;
        MergeSortedArrays obj = new MergeSortedArrays();
        int[] sortedArr = obj.mergeSortedArrays(nums1, nums2);

        if(sortedArr.length % 2 != 0) {
            median =  sortedArr[sortedArr.length/2];
        }
        else
            median = ((double)sortedArr[(sortedArr.length/2) - 1] + sortedArr[sortedArr.length/2])/2;

        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        MedianOfSortedArrays obj = new MedianOfSortedArrays();
        System.out.println(obj.medianOfSortedArrays(nums1, nums2));
    }
}
