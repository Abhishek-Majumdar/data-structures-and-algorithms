package main.com.leetcode.dsa.lcpractice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverseInteger(int toReverse){
        long reversed = 0;
        long divisor = 10;
        if(toReverse == 0)
            return 0;
        if(toReverse%10 == toReverse)
            return toReverse;

        List<Long> digitsInInteger = new ArrayList<>();
        while(toReverse%divisor != toReverse){
            digitsInInteger.add((toReverse%divisor)/(divisor/10));
            divisor*=10;
        }
        digitsInInteger.add((toReverse%divisor)/(divisor/10));

        for(int i=0; i<digitsInInteger.size(); i++) {
            reversed += (digitsInInteger.get(i) * (Math.pow(10, (digitsInInteger.size() - i - 1))));
        }

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
            return 0;

        return (int) reversed;
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        System.out.println(obj.reverseInteger(1534236469));
    }

}
