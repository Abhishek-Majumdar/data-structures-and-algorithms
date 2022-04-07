package main.com.leetcode.dsa.lcpractice;

public class EvenOddPrinter extends Thread {

    public void printEvenNumbers(int N){
        int counter = 0;
        int num = 2;

        while(counter < N){
            System.out.println(num);
            num += 2;
            counter += 1;
        }
    }

    public void printOddNumbers(int N){
        int counter = 0;
        int num = 1;

        while(counter < N){
            System.out.println(num);
            num += 2;
            counter += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EvenOddPrinter obj = new EvenOddPrinter();
        int N = 100;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEvenNumbers(N);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOddNumbers(N);
            }
        });

        thread1.start();
        thread2.start();
    }
}

