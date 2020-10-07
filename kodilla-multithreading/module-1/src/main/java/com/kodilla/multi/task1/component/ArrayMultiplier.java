package com.kodilla.multi.task1.component;

public final class ArrayMultiplier implements Runnable {

    private final ArrayData arrayData;
    private final int multiplier;

    public ArrayMultiplier(final ArrayData arrayData, final int multiplier) {
        this.arrayData = arrayData;
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " has been started");
        boolean isMultiplied = arrayData.multiply(multiplier);
        while (isMultiplied) {
            isMultiplied = arrayData.multiply(multiplier);
        }
    }

}
