package com.kodilla.threads.task4;

import java.util.Random;

public class Consumer implements Runnable {

    private final Database database;
    private final int consumerId;
    private final int customersToArchive;

    public Consumer(Database database, int consumerId, int customersToArchive) {
        this.database = database;
        this.consumerId = consumerId;
        this.customersToArchive = customersToArchive;
    }

    @Override
    public void run() {
        Random random = new Random();
        int counter = 0;
        while (counter < customersToArchive) {
            int idToCheck = random.nextInt(80);
            Customer customer = database.select(idToCheck);
            if (customer != null) {
                ThreadUtils.threadSleep(random.nextInt(1000));
                Customer newCustomer = new Customer(customer.getId(), customer.getName(), customer.getAddBy(), "Customer_" + consumerId);
                if (database.archiveCustomer(newCustomer))
                    counter++;
            }
        }
    }

}
