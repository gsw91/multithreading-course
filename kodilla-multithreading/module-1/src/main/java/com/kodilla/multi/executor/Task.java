package com.kodilla.multi.executor;

import java.util.Random;

public class Task implements Runnable {

    private static int counter;

    @Override
    public void run() {
        taskBody();
    }

    private void taskBody() {
        Random random = new Random();
        int delay = random.nextInt(100);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Task.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " finished, counter = " + counter);
        }
    }

}

