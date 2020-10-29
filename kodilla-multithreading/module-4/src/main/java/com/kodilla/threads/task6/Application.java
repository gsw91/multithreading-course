package com.kodilla.threads.task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final ResourceA resourceA = new ResourceA();
        final ResourceB resourceB = new ResourceB();
        for (int n = 0; n < 500; n++) {
            executorService.submit(new ProcessA(resourceA, resourceB));
            executorService.submit(new ProcessB(resourceA, resourceB));
        }
        executorService.shutdown();
    }
}