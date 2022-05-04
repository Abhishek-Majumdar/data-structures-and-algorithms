package main.com.leetcode.dsa.lcpractice;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : nums){
            if(count.containsKey(num))
                count.put(num, 2);
            else
                count.put(num, 1);
        }

        for(int key : count.keySet()){
            if(count.get(key) == 1)
                return key;
        }

        return -1;
    }
}
