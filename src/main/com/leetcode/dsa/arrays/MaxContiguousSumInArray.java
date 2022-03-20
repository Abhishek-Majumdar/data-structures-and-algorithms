package main.com.leetcode.dsa.arrays;

public class MaxContiguousSumInArray {

    /**
     * KADANE's ALGORITHM O(n)
     * The simple idea of Kadane’s algorithm is to look for all positive
     * contiguous segments of the array (max_ending_here is used for this).
     * And keep track of maximum sum contiguous segment among all positive segments
     * max_so_far is used for this). Each time we get a positive-sum compare it with
     * max_so_far and update max_so_far if it is greater than max_so_far.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxTillHere = 0;

        for(int i=0; i<nums.length; i++){
            maxTillHere += nums[i];
            maxSoFar = Math.max(maxSoFar, maxTillHere);
            if(maxTillHere < 0)
                maxTillHere = 0;
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxContiguousSumInArray obj = new MaxContiguousSumInArray();
        int[] arr = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        int[] arr2 = {5,4,-1,7,8};

        System.out.println(obj.maxSubArray(arr));
    }
}
