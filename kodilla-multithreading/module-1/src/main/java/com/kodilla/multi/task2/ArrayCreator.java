package com.kodilla.multi.task2;

import java.util.Random;

public final class ArrayCreator {

    private final Random random = new Random();
    private final int arrayLength;
    private final int intBound;

    public ArrayCreator(int arrayLength, int intBound) {
        this.arrayLength = arrayLength;
        this.intBound = intBound;
    }

    public int[] createArray() {
        int[] array = new int[arrayLength];
        int i = 0;
        while(i<arrayLength) {
            array[i] = random.nextInt(intBound);
            i++;
        }
        return array;
    }

}
