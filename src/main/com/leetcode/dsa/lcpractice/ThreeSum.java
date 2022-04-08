package main.com.leetcode.dsa.lcpractice;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> tripletsWithZeroSum(int[] arr){
        if(arr.length < 3)
            return Collections.emptyList();

        List<List<Integer>> tripletsWithZeroSum = new ArrayList<>();
        Map<Integer, Integer> complimentMap;
        List<Integer> tmpList;
        Set<String> uniqueTriplets = new HashSet<>();
        int firstNum;
        int secondNum;
        String uniqueTriplet;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1; i++){
            firstNum = arr[i];
            complimentMap = new HashMap<>();
            for(int j = i+1; j < arr.length; j++) {
                secondNum = arr[j];
                if (complimentMap.containsKey(-firstNum - secondNum)) {
                    if(i != j && i != complimentMap.get(-firstNum - secondNum) &&
                            j != complimentMap.get(-firstNum - secondNum)) {
                        tmpList = new ArrayList<>();
                        tmpList.add(firstNum);
                        tmpList.add(secondNum);
                        tmpList.add(-firstNum - secondNum);
                        uniqueTriplet = String.format("%s:%s:%s", firstNum, secondNum, -firstNum - secondNum);
                        if(! uniqueTriplets.contains(uniqueTriplet))
                            tripletsWithZeroSum.add(tmpList);
                        uniqueTriplets.add(uniqueTriplet);
                    }
                } else {
                    complimentMap.put(secondNum, j);
                }
            }
        }

        return tripletsWithZeroSum;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(obj.tripletsWithZeroSum(arr));

    }

}
