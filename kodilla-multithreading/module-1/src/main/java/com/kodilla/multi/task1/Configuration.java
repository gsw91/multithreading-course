package com.kodilla.multi.task1;

import com.kodilla.multi.task1.component.ArrayData;
import com.kodilla.multi.task1.component.ArrayMultiplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Configuration {

    private final List<Thread> threads = new ArrayList<>();
    private ArrayData arrayData;
    private int arrayLength = 10;
    private int threadsQuantity = 1;
    private int multiplier = 1;

    public Configuration() {
        createArray();
    }

    public ArrayData getArray() {
        return arrayData;
    }

    public void changeDefaultArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
        createArray();
    }

    public void setThreadsQuantity(int threadsQuantity) {
        this.threadsQuantity = threadsQuantity;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public void run() {
        showArray("before");
        createThreads(multiplier);
        joinThreads();
        showArray("after");
    }

    private void createArray() {
        this.arrayData = new ArrayData(arrayLength);
    }

    private void showArray(String message) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(arrayData.getArray()).forEach(t -> {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(t);
        });
        System.out.println("Array - "+ message + ": " + builder.toString());
    }

    private void createThreads(int multiplier) {
        int var = 0;
        while (var < threadsQuantity) {
            var ++;
            Thread thread = new Thread(new ArrayMultiplier(arrayData, multiplier));
            thread.setName("Thread " + var);
            thread.start();
            threads.add(thread);
        }
    }

    private void joinThreads() {
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
