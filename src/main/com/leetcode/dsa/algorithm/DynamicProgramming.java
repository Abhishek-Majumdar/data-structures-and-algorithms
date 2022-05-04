package main.com.leetcode.dsa.algorithm;

public class DynamicProgramming {

    public int nthFibonacciNumber(int n){
        int[] fibonacciSequence = new int[n+2];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for(int i =2; i<=n; i++){
            fibonacciSequence[i] = fibonacciSequence[i-1] + fibonacciSequence[i-2];
        }

        return fibonacciSequence[n];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.nthFibonacciNumber(7));
    }

}
