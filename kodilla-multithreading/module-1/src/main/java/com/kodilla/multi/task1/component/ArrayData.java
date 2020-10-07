package com.kodilla.multi.task1.component;

import java.util.Random;

public final class ArrayData {

    private final int[] array;
    private int currId;

    public ArrayData(int arrayLength) {
        this.array = new int[arrayLength];
        Random random = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public int[] getArray() {
        return array;
    }

    public synchronized boolean multiply(int multiplier) {
         if (currId >= array.length) {
            System.out.println("All up to date, checked by thread: " + Thread.currentThread().getName());
            return false;
        }
        System.out.println("Multiplying by thread: " + Thread.currentThread().getName() + " , index: " + currId + ", old value: " + array[currId] + ", multiplier: " + multiplier);
        array[currId] *= multiplier;
        currId++;
        return true;
    }

}
