package com.kodilla.multi.simple;

import com.kodilla.multi.sum.PartialCalc;
import com.kodilla.multi.sum.Reducer;

public class Application {

    public static void main(String[] args) {
//        Counter c1 = new Counter();
//        Counter c2 = new Counter();
//        c1.start();
//        c2.start();

//        Thread t1 = new Thread(new CounterRunnable());
//        Thread t2 = new Thread(new CounterRunnable());
//        t1.start();
//        t2.start();

        int[] anArray = new int[1000];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = 1;
        }

        Reducer reducer = new Reducer();

        PartialCalc p1 = new PartialCalc(reducer, anArray, 0, 500);
        PartialCalc p2 = new PartialCalc(reducer, anArray, 500, anArray.length);

        p1.start();
        p2.start();

        try {
            p1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        try {
            p2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(reducer.getCounter());
    }

}
