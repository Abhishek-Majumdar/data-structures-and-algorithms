package main.com.leetcode.dsa.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public void shiftArrayToLeft(int[] nums, int index){
        for(int i=index; i<nums.length-1; i++){
            nums[i] = nums[i+1];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Traverse along the array and check below conditions,
     * 1. If found zero, DO NOTHING
     * 2. If found non-zero, swap it with the last seen zero -
     * maintain using a separate pointer; move the pointer to right
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int numsLimit = nums.length;
        /*int tmpForSwap;

        for(int i=0; i<numsLimit; i++){
            if(nums[i] == 0){
                tmpForSwap = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmpForSwap;
            }
        }*/

        /*for(int i=0; i<numsLimit; i++){
            if(nums[i] == 0){
                shiftArrayToLeft(nums, i);
                nums[nums.length-1] = 0;
            }

            if(i<=numsLimit-1 && nums[i+1] ==0)
                i--;
        }*/

        if(nums.length < 2)
            return;
        int count = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, count);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] arr1 = {0,1,0,0,4,5,6,0};

        obj.moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
