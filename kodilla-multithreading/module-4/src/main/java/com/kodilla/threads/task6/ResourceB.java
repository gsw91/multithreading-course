package com.kodilla.threads.task6;

public final class ResourceB {

    public synchronized String getResource() throws InterruptedException {
        Thread.sleep(50);
        return "Here is resource B";
    }

}
