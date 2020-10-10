package com.kodilla.multi.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Configuration {

    private final ArrayCreator arrayCreator = new ArrayCreator(10000, 9999);
    private final int[] arrayOne = arrayCreator.createArray();
    private final int[] arrayTwo = arrayCreator.createArray();
    private final long[] resultArray = new long[arrayOne.length];

    public void run() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        for (int i=0; i<10; i++) {
            executor.submit(new ArrayMultiplier(arrayOne, arrayTwo, resultArray));
        }
        executor.shutdown();

        while (!executor.isTerminated()) { // bez tego zaczną się wyświetlać wyniki za wcześnie, niektóre będą na "0"
            try {
                Thread.sleep(100);
                System.out.println("Wait a sec, multiplier is still working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i=0; i<resultArray.length; i++) {
            System.out.println(i + ". Result of " + arrayOne[i] + " * " + arrayTwo[i] + " is " + resultArray[i]);
        }
    }

}
