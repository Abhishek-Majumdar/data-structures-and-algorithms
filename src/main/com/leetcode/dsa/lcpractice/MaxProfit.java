package main.com.leetcode.dsa.lcpractice;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice;
        int duration = prices.length - 1;
        int tmpProfit = 0;
        int sellPtr;
        int buyPtr = 0;

        while(buyPtr < duration){
            buyPrice = prices[buyPtr];
            for(sellPtr = buyPtr+1; sellPtr <= duration; sellPtr++){
                tmpProfit = Math.max(tmpProfit, prices[sellPtr] - buyPrice);
            }
            if(tmpProfit > 0) {
                maxProfit += tmpProfit;
                buyPtr = sellPtr;
            }
            else
                buyPtr++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(MaxProfit.maxProfit(prices));
    }
}
