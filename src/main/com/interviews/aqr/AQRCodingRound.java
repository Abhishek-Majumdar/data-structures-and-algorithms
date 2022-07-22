package main.com.interviews.aqr;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AQRCodingRound {

    public static double mean(double[] arr){
        if(arr.length == 0)
            return 0.0;

        double sum = 0.0;
        for(double elem : arr){
            sum += elem;
        }

        return sum/arr.length;
    }

    // sqrt ((sum(xi - x)^2)/n-1)
    public static double stdDev(double[] arr){
        if(arr.length == 0)
            return 0.0;

        double mean = mean(arr);
        double diffSum = 0.0;

        for(double elem : arr){
            diffSum += Math.pow((elem - mean),2);
        }

        return Math.sqrt(diffSum/(arr.length -1));
    }

    //List of (list<Integer> (sorted asc))

    /*public List<Integer> generateSortedList(List<List<Integer>> sortedSubLists){
        List<Integer> sortedList = new ArrayList<>();
        int[] arrPtr = new int[sortedSubLists.size()];

        int numberOfSubLists = sortedSubLists.size();

        while(){

        }



        return sortedList;
    } */

    public static long numberOfWaysToClimbStair(int n){
        if(n <= 2)
            return n;

        int[] arrSteps = new int[n];

        arrSteps[0] = 1;
        arrSteps[1] = 2;

        for(int i = 2; i < n; i++){
            arrSteps[i] = arrSteps[i-1] + arrSteps[i-2];
        }

        return arrSteps[n-1];
    }

    //List of numbers, sum
    public static boolean sumExistsInList(List<Integer> list, int sum){
        Map<Integer, Integer> compliment = new HashMap<>();
        int tmpCompliment;

        for(int i = 0; i < list.size(); i++){
            tmpCompliment = sum - list.get(i);
            if(compliment.containsKey(tmpCompliment))
                return true;
            else{
                compliment.put(list.get(i), i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*double[] arr = {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0};
        System.out.println(AQRCodingRound.stdDev(arr));*/

        // System.out.println(AQRCodingRound.numberOfWaysToClimbStair(4));

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(3);

        System.out.println(AQRCodingRound.sumExistsInList(list, 13));
    }



}
