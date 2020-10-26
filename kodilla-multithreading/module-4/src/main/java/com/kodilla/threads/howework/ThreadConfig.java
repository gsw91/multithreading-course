package com.kodilla.threads.howework;

import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadConfig {

    private static Runnable RUNNABLE;
    private final int maxThreadsQty = 50;
    private final AtomicInteger counter = new AtomicInteger();

    public ThreadConfig() {
        RUNNABLE = () -> {
            System.out.println("Hello from Thread number " + counter.incrementAndGet());
            if (counter.get() < maxThreadsQty) {
                new Thread(RUNNABLE).start();
            }
        };
    }

    public void startThreads() {
        Thread thread = new Thread(RUNNABLE);
        thread.start();
    }

}
