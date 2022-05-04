package main.com.leetcode.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

//Solved optimally - O(n)
public class DuplicateInArray {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for(int num : nums){
            if(uniques.contains(num)){
                return true;
            }
            else
                uniques.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateInArray obj = new DuplicateInArray();
        int[] arr = {0,22,4,5,6, 6};
        System.out.println(obj.containsDuplicate(arr));
    }
}
