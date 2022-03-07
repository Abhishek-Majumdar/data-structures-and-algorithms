package main.com.leetcode.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Solved sub-optimally O(n^2) //TODO : Linear time solution
public class RotateArray {

    public void shiftArrayToRight(int[] nums){
        int lastElement = nums[nums.length-1];
        int size = nums.length-1;

        for(int i=size; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = lastElement;
    }

    public void rotate(int[] nums, int k) {
        int effectiveRotations = k%nums.length;
        for(int i=1; i<=effectiveRotations; i++)
            shiftArrayToRight(nums);
    }

    public void rotateBetter(int[] nums, int k) {
        int effectiveRotations = k%nums.length;
        List<Integer> elementsToRotate = new ArrayList<>();

        for(int i=nums.length-effectiveRotations; i<nums.length; i++)
            elementsToRotate.add(nums[i]);
        // TODO : Try implementing in linear time
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] arr = {5,4,3,7,9,1};

        obj.rotate(arr,5);
        System.out.println(Arrays.toString(arr));
    }

}
