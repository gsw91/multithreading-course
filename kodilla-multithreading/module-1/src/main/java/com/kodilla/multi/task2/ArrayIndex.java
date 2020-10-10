package com.kodilla.multi.task2;

public final class ArrayIndex {

    private static volatile int INDEX = -1;

    public synchronized static int GET_INDEX() {
        INDEX++;
        return INDEX;
    }
}
