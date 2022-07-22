package main.com.interviews.aqr;

import java.util.ArrayList;
import java.util.List;

public class ObjectReference {

    public static void increment(Integer i){
        i++;
    }

    public static void append(List<Integer> l){
        l = new ArrayList<>();
        l.add(1);
    }

    public static void swap(List<Integer> l1, List<Integer> l2){
        List<Integer> tmp;
        tmp = l1;
        l1 = l2;
        l2 = tmp;
    }

    public static void main(String[] args) {

        Integer i =1;
        increment(i);
        System.out.println(i);

        List<Integer> x = new ArrayList();
        append(x);

        List<Integer> y = new ArrayList();
        List<Integer> z = new ArrayList();
        y.add(6);
        z.add(7);

        swap(y,z);
        System.out.println(y);
    }
}
