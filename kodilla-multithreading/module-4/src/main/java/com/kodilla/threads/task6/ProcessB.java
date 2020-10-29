package com.kodilla.threads.task6;

public final class ProcessB implements Runnable {

    private final ResourceA resourceA;
    private final ResourceB resourceB;

    public ProcessB(final ResourceA resourceA, final ResourceB resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " - Process B, part 1, " + resourceB.getResource());
            System.out.println(Thread.currentThread().getName() + " - Process B, part 2, " + resourceA.getResource());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}