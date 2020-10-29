package com.kodilla.threads.task6;

public final class ProcessA implements Runnable {

    private final ResourceA resourceA;
    private final ResourceB resourceB;

    public ProcessA(final ResourceA resourceA, final ResourceB resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " - Process A, part 1, " + resourceA.getResource());
            System.out.println(Thread.currentThread().getName() + " - Process A, part 2," + resourceB.getResource());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}