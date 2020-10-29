package com.kodilla.threads.task6;

public final class ResourceA {

    public synchronized String getResource() throws InterruptedException {
        Thread.sleep(50);
        return "Here is resource A";
    }

}
