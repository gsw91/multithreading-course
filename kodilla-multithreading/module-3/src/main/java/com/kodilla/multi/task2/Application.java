package com.kodilla.multi.task2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        final CountDownLatch theLatch = new CountDownLatch(5);

        executor.submit(new TaskRunnable(theLatch, "one"));
        executor.submit(new TaskRunnable(theLatch, "two"));
        executor.submit(new TaskRunnable(theLatch, "three"));
        executor.submit(new TaskRunnable(theLatch, "four"));
        executor.submit(new TaskRunnable(theLatch, "five"));

        try {
            theLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The latch has been closed");

        executor.shutdown();
    }


}
