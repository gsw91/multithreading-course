package com.kodilla.multi.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Configuration {

    private final WebClientMock mock = new WebClientMock();

    public void run() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i=0; i<500; i++) {
            executor.submit(new FileDownloader(mock));
        }
        executor.shutdown();

    }

}
