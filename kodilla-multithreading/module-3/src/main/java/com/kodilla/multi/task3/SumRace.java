package com.kodilla.multi.task3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public final class SumRace implements Runnable {

    private final CyclicBarrier barrier;
    private final ResultList resultList;

    public SumRace(CyclicBarrier barrier, ResultList resultList) {
        this.barrier = barrier;
        this.resultList = resultList;
    }

    @Override
    public void run() {
         int sumA = 1000;
         int sumB = 0;
         int counter = 0;
        Random random = new Random();

         while (sumA >= sumB) {
             counter++;
             sumA += random.nextInt(10);
             sumB += random.nextInt(50);
             System.out.println("Thread: " + Thread.currentThread().getName() + ", iteration: " + counter + ", sum A: " + sumA + ", sum B" + sumB);
         }

        try {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", adding results to list...");
            resultList.add(new int[]{sumA, sumB, counter});
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


}
