package com.kodilla.multi.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public final class ResultList {

    private final List<int[]> resultList = new ArrayList<>();
    private final StampedLock lock = new StampedLock();

    public void add(int[] results) {
        long stamp = lock.writeLock();
        resultList.add(results);
        lock.unlockWrite(stamp);
    }

    public void showResults() {
        long stamp = lock.readLock();
        resultList.forEach(t -> System.out.println("Sum A: " + t[0] + ", Sum B: " + t[1] + ", Last Iteration: " + t[2]));
        lock.unlockRead(stamp);
    }

}
