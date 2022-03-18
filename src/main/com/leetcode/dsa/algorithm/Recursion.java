package main.com.leetcode.dsa.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Recursion {

    public long computeFactorial(long num){
        long factorial;
        if(num == 1){
            return 1;
        }

        factorial = num * computeFactorial(num-1);
        return factorial;
    }

    public long computeFactorialIterative(long num){
        long factorial = 1;
        for(long n = num; n >=1; n--){
            factorial *= n;
        }

        return factorial;
    }

    public int nthFibonacciNumber(int num){
        int nthFibonacciNumber = 0;
        if(num == 0)
            return 0;
        if(num == 1 || num == 2)
            return 1;

        nthFibonacciNumber = nthFibonacciNumber(num-1) + nthFibonacciNumber(num-2);
        return nthFibonacciNumber;
    }

    public int nthFibonacciNumberIterativeUsingList(int num){
        int nthFibonacciNumber = 0;
        if(num == 0)
            return 0;
        if(num == 1 || num == 2)
            return 1;

        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0);
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);

        for(int i = 3; i <= num; i++){
            fibonacciNumbers.add(fibonacciNumbers.get(i-1) + fibonacciNumbers.get(i-2));
        }
        nthFibonacciNumber = fibonacciNumbers.get(fibonacciNumbers.size() -1);
        return nthFibonacciNumber;
    }

    public int nthFibonacciNumberIterative(int num){
        int nthFibonacciNumber = 0;
        if(num == 0)
            return 0;
        if(num == 1 || num == 2)
            return 1;

        int last = 1;
        int secondLast = 1;

        for(int i = 3; i <= num; i++)
        {
            nthFibonacciNumber = last + secondLast;
            secondLast = last;
            last = nthFibonacciNumber;
        }
        return nthFibonacciNumber;
    }

    public void recursiveReverse(char[] stringToReverse, int i){
        int n = stringToReverse.length;
        if (i == n / 2)
            return;
        swap(stringToReverse,i,n - i - 1);
        recursiveReverse(stringToReverse, i + 1);
    }

    public void swap(char []arr, int i, int j){
        char temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        Recursion obj = new Recursion();

        System.out.println(obj.computeFactorial(10));
        System.out.println(obj.computeFactorialIterative(10));

        System.out.println(obj.nthFibonacciNumberIterativeUsingList(11));
        System.out.println(obj.nthFibonacciNumberIterative(11));
        System.out.println(obj.nthFibonacciNumber(11));

        char[] toReverse = "Reverse this string".toCharArray();
        char[] toReverse2 = "aabbcbbaa".toCharArray();
        obj.recursiveReverse(toReverse2, 0);
        System.out.println(toReverse2);
    }

}
