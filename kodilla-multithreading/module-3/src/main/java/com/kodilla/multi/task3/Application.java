package com.kodilla.multi.task3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        ResultList resultList = new ResultList();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new FinalMessage(resultList));
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i=0; i<5; i++) {
            service.submit(new SumRace(cyclicBarrier, resultList));
        }

        service.shutdown();
    }

}
