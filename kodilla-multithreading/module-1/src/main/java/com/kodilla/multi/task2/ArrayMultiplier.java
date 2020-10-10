package com.kodilla.multi.task2;

public final class ArrayMultiplier implements Runnable {

    private final int[] arrayOne;
    private final int[] arrayTwo;
    private final long[] resultArray;

    public ArrayMultiplier(int[] arrayOne, int[] arrayTwo, long[] resultArray) {
        this.arrayOne = arrayOne;
        this.arrayTwo = arrayTwo;
        this.resultArray = resultArray;
    }

    @Override
    public void run() {
        multiplyArrays();
    }

    public void multiplyArrays() {
        if (arrayOne.length != arrayTwo.length && arrayOne.length != resultArray.length) {
            System.out.println("Arrays not equal! Cannot multiply those arrays!");
            return;
        }
        while (true) {
            int index = ArrayIndex.GET_INDEX();
            if (index >= arrayOne.length)
                break;
            System.out.println("Count index " + index + " by thread " + Thread.currentThread().getName() + ", operation: " + arrayOne[index] + " * " + arrayTwo[index] + " = " + arrayOne[index] * arrayTwo[index]);
            resultArray[index] = arrayOne[index] * arrayTwo[index];
        }
    }

}
