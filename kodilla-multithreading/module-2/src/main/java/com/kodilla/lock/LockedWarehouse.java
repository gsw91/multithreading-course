package com.kodilla.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.kodilla.util.SleepUtil.sleep;

public class LockedWarehouse {

    private final Map<Product, Integer> products = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();

    public void add(Product product, String by) {
        System.out.println("I'm " + by + " and want to add " + product);
        writeLock.lock();
        try {
            sleep(2);
            products.merge(product, 1, Integer::sum);
            System.out.println("+ Product " + product + " added by " + by + ". Now is  " + countProducts());
        } finally {
            writeLock.unlock();
        }
    }

    public void showProducts(String inventoryWorkerName) {
        System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY");
        readLock.lock();
        try {
            products.forEach((key, value) ->
                    System.out.println("[" + inventoryWorkerName + "]" + "Product: " + key + " quantity: " + value));
        } finally {
            readLock.unlock();
        }
    }

    public void removeProduct(Product product, String sellerName) {
        System.out.println("I'm " + sellerName + " and want to sell one " + product);
        writeLock.lock();
        try {
            if (products.containsKey(product) && products.get(product) > 0) {
                products.merge(product, -1, Integer::sum);
                System.out.println("- " + product + " sold, current available quantity: " + products.get(product));
            } else {
                System.out.println("Temporary we do not have the item: " + product + ", try later");
            }
        } finally {
            writeLock.unlock();
        }
    }

    private int countProducts() {
        readLock.lock();
        try {
            return products.values().stream().reduce(0, Integer::sum);
        } finally {
            readLock.unlock();
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}