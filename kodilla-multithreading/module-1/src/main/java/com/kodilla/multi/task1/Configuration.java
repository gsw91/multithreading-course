package com.kodilla.multi.task1;

import com.kodilla.multi.task1.component.ArrayData;
import com.kodilla.multi.task1.component.ArrayMultiplier;

public final class Configuration {

    private final ArrayData arrayData;

    public Configuration(int arrayLength) {
        this.arrayData = new ArrayData(arrayLength);
    }

    public void run(int multiplier) {
//        Arrays.stream(array.getArray()).forEach(System.out::println);

        Thread t1 = new Thread(new ArrayMultiplier(arrayData, multiplier));
        Thread t2 = new Thread(new ArrayMultiplier(arrayData, multiplier));
        Thread t3 = new Thread(new ArrayMultiplier(arrayData, multiplier));

        t1.setName("Thread One");
        t2.setName("Thread Two");
        t3.setName("Thread Three");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Arrays.stream(array.getArray()).forEach(System.out::println);
    }

    public ArrayData getArray() {
        return arrayData;
    }

}
