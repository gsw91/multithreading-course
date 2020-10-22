package com.kodilla.multi.task4;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookApp {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Exchanger<Book> exchanger = new Exchanger<>();

        service.submit(new BookExchProducer(exchanger, 20));
        service.submit(new BookExchConsumer(exchanger));

        service.shutdown();

    }

}
