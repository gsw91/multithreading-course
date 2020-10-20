package com.kodilla.multi.task2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TaskRunnable implements Runnable {

    private final CountDownLatch theLatch;
    private final String taskName;

    public TaskRunnable(CountDownLatch theLatch, String taskName) {
        this.theLatch = theLatch;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        Random random = new Random();

        final int[] delayed = new int[]{0};
        random.ints(50, 2000)
                .findFirst()
                .ifPresent(t -> delayed[0] = t);
        System.out.println("Thread " + Thread.currentThread().getName() + " task " + taskName + " takes " + delayed[0] + " [ms]");

        try {
            Thread.sleep(delayed[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        theLatch.countDown();

        System.out.println("Task " + taskName + " executed");

    }

}
