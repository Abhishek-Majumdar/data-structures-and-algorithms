package main.com.leetcode.dsa.lcpractice;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public int containerWithMostWater(int[] arr){
        int highestCapacity = 0;
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while(leftPtr < rightPtr){
            highestCapacity = Math.max(highestCapacity, (rightPtr-leftPtr)*Math.min(arr[leftPtr], arr[rightPtr]));
            if(arr[leftPtr] < arr[rightPtr])
                leftPtr++;
            else
                rightPtr--;
        }

        return highestCapacity;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.containerWithMostWater(arr));
    }

}
