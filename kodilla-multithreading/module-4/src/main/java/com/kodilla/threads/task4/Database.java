package com.kodilla.threads.task4;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database {

    private final int workingListCapacity;

    private final List<Customer> customerList = new ArrayList<>();
    private final List<Customer> customerArchive = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock archiveLock = lock.writeLock();
    private final Condition noMoreSpace = writeLock.newCondition();

    public Database(int workingListCapacity) {
        this.workingListCapacity = workingListCapacity;
    }

    public void insert(Customer customer) {
        writeLock.lock();
        try {
            while (customerList.size() == workingListCapacity) {
                System.out.println(Thread.currentThread().getId() + " - No more space, waiting...");
                noMoreSpace.await();
            }
            int currentId = atomicInteger.incrementAndGet();
            Customer newCustomer = new Customer(currentId, customer.getName(), customer.getAddBy(), customer.getArchivedBy());
            customerList.add(newCustomer);
            System.out.println(Thread.currentThread().getId() + " - INSERT - New customer added: " + newCustomer + ", collection size: " + customerList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public Customer select(int id) {
        readLock.lock();
        try {
            Customer customer = customerList.stream()
                    .filter(t -> t.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (customer != null) {
                System.out.println(Thread.currentThread().getId() + " - SELECT - Customer of ID: " + id + ", " + customer);
            } else {
                Customer archivedCustomer = customerArchive.stream()
                        .filter(t -> t.getId() == id)
                        .findFirst()
                        .orElse(null);
                if (archivedCustomer != null) {
                    System.out.println(Thread.currentThread().getId() + " - SELECT - Customer of ID: " + id + " has been archived, " + customer);
                } else {
                    System.out.println(Thread.currentThread().getId() + " - Customer of ID: " + id + " was not created yet");
                }
            }
            return customer;
        } finally {
            readLock.unlock();
        }
    }

    public boolean archiveCustomer(Customer customer) {
        archiveLock.lock();
        try {
            boolean isArchived = customerArchive.stream()
                    .anyMatch(t -> t.getId() == customer.getId());
            if (isArchived) {
                System.out.println(Thread.currentThread().getId() + " - ARCHIVE - Customer has been archived!!! " + customer);
                return false;
            }

            System.out.println(Thread.currentThread().getId() + " - ARCHIVE - Customer to archive: " + customer + ", list size: " + customerList.size() + ", archive size: " + customerArchive.size());
            customerList.removeIf(t -> t.getId() == customer.getId());
            customerArchive.add(customer);
            System.out.println(Thread.currentThread().getId() + " - ARCHIVE - Customer archived, list size: " + customerList.size() + ", archive size: " + customerArchive.size());
            noMoreSpace.signal();
            return true;
        } finally {
            archiveLock.unlock();
        }
    }

    public void showCollectionsSize() {
        readLock.lock();
        try {
            System.out.println("Current list size: " + customerList.size());
            customerList.forEach(System.out::println);
            System.out.println("Archive list size: " + customerArchive.size());
            customerArchive.forEach(System.out::println);
        } finally {
            readLock.unlock();
        }
    }

}
