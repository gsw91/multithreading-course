package com.kodilla.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.kodilla.util.SleepUtil.sleep;

public class LockTest {
    public static void main(String[] args) {
        final LockedWarehouse lockedWarehouse = new LockedWarehouse();
        int cores = Runtime.getRuntime().availableProcessors();
        final ExecutorService executorService = Executors.newFixedThreadPool(cores);
        executorService.submit(new Seller("Seller 1", lockedWarehouse));
        executorService.submit(new Worker("Worker 1", lockedWarehouse));
        executorService.submit(new InventoryWorker("Inventory 1", lockedWarehouse));
        executorService.submit(new Worker("Worker 2", lockedWarehouse));
        executorService.submit(new Seller("Seller 2", lockedWarehouse));
        executorService.submit(new Worker("Worker 3", lockedWarehouse));
        executorService.submit(new Seller("Seller 3", lockedWarehouse));
        executorService.submit(new InventoryWorker("Inventory 2", lockedWarehouse));
        executorService.submit(new Seller("Seller 4", lockedWarehouse));
        executorService.shutdown();
        System.out.println("Current stock: ");

        while (!executorService.isTerminated()) {
            sleep(1);
        }
        System.out.println("\n CURRENT STOCKS: \n");
        lockedWarehouse.getProducts().forEach((k,v) -> System.out.println("Product: " + k + ", quantity " + v));
    }
}
