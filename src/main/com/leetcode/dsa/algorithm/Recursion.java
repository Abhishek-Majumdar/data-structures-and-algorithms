package main.com.leetcode.dsa.algorithm;

public class Recursion {

    public long computeFactorial(long num){
        long factorial = 1;
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

    //public

    public static void main(String[] args) {
        Recursion obj = new Recursion();

        System.out.println(obj.computeFactorial(10));
        System.out.println(obj.computeFactorialIterative(10));
    }

}
