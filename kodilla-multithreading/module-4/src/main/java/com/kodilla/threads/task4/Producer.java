package com.kodilla.threads.task4;

import java.util.Random;

public class Producer implements Runnable {

    private final Database database;
    private final int producerId;
    private final int customersToAdd;

    public Producer(Database database, int producerId, int customersToAdd) {
        this.database = database;
        this.producerId = producerId;
        this.customersToAdd = customersToAdd;
    }

    @Override
    public void run() {
        Random random = new Random();
        int counter = 0;
        while (counter<customersToAdd) {
            ThreadUtils.threadSleep(random.nextInt(500));
            String name = "customer_" + counter + "_" + Thread.currentThread().getName();
            String addBy = "producer_" + producerId;
            Customer customer = new Customer(0, name, addBy, null);
            database.insert(customer);
            counter++;
        }
    }

}
