package com.kodilla.multi.sum;

public class Reducer {

    private int counter;

    public synchronized void add(int value) {
        counter += value;
    }

    public int getCounter() {
        return counter;
    }

}
