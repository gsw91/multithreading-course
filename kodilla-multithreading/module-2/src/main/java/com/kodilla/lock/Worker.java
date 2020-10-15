package com.kodilla.lock;

import com.kodilla.util.SleepUtil;

import java.util.Random;

public class Worker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public Worker(String workerName, LockedWarehouse warehouse) {
        this.warehouse = warehouse;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            SleepUtil.sleep(1);
            final Random random = new Random();
            final int id = random.nextInt(3);

            if (id == 0) {
                warehouse.add(Product.BOOK, workerName);
            } else if (id == 1) {
                warehouse.add(Product.ELECTRONICS, workerName);
            } else {
                warehouse.add(Product.TOYS, workerName);
            }
        }
    }

}