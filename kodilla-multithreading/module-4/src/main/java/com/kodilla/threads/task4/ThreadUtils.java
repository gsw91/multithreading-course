package com.kodilla.threads.task4;

public final class ThreadUtils {

    public static void threadSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
