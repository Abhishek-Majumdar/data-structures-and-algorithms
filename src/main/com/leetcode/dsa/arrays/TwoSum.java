package main.com.leetcode.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Solved without hints - Optimal solution O(n)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> complimentIndicesMap = new HashMap<Integer, Integer>();
        int compliment;
        int num;

        for(int i=0; i< nums.length; i++)
        {
            num = nums[i];
            compliment = target - num;
            if(complimentIndicesMap.containsKey(compliment)){
                indices[0] = i;
                indices[1] = complimentIndicesMap.get(compliment);
                return indices;
            }
            else
                complimentIndicesMap.put(num, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,7,1,8};
        int target = 6;

        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));

    }
}
