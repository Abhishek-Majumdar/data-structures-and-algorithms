package main.com.leetcode.dsa.lcpractice;

/*
Given n non-negative integers representing an elevation map
where the width of each bar is 1, compute how much water
it can trap after raining.

https://leetcode.com/problems/trapping-rain-water
*/

public class TrapRainWater {

    public int trapRainWater(int[] height){
        int l = 0, r = height.length - 1;
        int L = height[l], R = height[r];

        int ans = 0;
        while(l <= r){
            if(L < R){
                L = Math.max(L, height[l]);
                ans += L - height[l++];
            }
            else{
                R = Math.max(R, height[r]);
                ans += R - height[r--];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TrapRainWater obj = new TrapRainWater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {5,4,3,2,1};

        System.out.println(obj.trapRainWater(height));
    }
}
