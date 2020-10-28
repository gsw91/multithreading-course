package com.kodilla.threads.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 1. Producers create customers
 2. Consumers randomly check if customers exist by id and then archive them
 */

public class Application {

    public static void main(String[] args) {
        Database db = new Database(10);
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i=1; i<5; i++) {
            service.submit(new Producer(db, i, 10));
            service.submit(new Consumer(db, i, 10));
        }
        service.shutdown();

        while (!service.isTerminated()) {
            ThreadUtils.threadSleep(100);
        }
        db.showCollectionsSize();
    }

}
