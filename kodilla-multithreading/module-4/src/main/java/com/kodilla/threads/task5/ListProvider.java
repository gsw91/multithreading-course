package com.kodilla.threads.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ListProvider {

    public CompletableFuture<List<Integer>> provideList(int size, int bound) {
        System.out.println("Providing list of integers, size: " + size + ", bound: " + bound);
        return CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            for (int i=0; i<size; i++) {
                list.add(random.nextInt(bound));
            }
            System.out.println("Prepared list: " + list);
            return list;
        });
    }

}