package main.com.leetcode.dsa.lcpractice;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public Object firstRecurringCharacter(int[] nums){
        Map<Integer, Integer> uniqueChars = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(uniqueChars.containsKey(nums[i]))
                return nums[i];
            else
                uniqueChars.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        FirstRecurringCharacter obj = new FirstRecurringCharacter();
        int nums[] = {2,1,5,7,9,0};

        System.out.println(obj.firstRecurringCharacter(nums));
    }

}
