package com.kodilla.multi.deadlock;

public class ProcessA implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(50);
            synchronized (ResourceA.class) {
                System.out.println("Process A, part 1");
                Thread.sleep(50);
                synchronized (ResourceB.class) {
                    System.out.println("Process A, part 2");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}