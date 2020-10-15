package com.kodilla.lock;

import com.kodilla.util.SleepUtil;

import java.util.Random;

public class Seller implements Runnable {

    private final String sellerName;
    private final LockedWarehouse warehouse;

    public Seller(String sellerName, LockedWarehouse warehouse) {
        this.warehouse = warehouse;
        this.sellerName = sellerName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            SleepUtil.sleep(1);
            final Random random = new Random();
            final int id = random.nextInt(3);
            if (id == 0) {
                warehouse.removeProduct(Product.BOOK, sellerName);
            } else if (id == 1) {
                warehouse.removeProduct(Product.ELECTRONICS, sellerName);
            } else {
                warehouse.removeProduct(Product.TOYS, sellerName);
            }
        }
    }

}
