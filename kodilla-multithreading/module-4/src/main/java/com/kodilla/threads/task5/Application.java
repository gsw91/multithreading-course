package com.kodilla.threads.task5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        final Set<Integer> validationSet = new HashSet<>();
        AtomicInteger duplicateCounter = new AtomicInteger();

        ListProvider providerOne = new ListProvider();
        ListProvider providerTwo = new ListProvider();

        providerOne.provideList(10000,10000)
                .thenCompose(list1 -> providerTwo.provideList(10000,10000)
                        .thenAccept(list2 -> {
                                    list1.addAll(list2);
                                    list1.forEach(t -> {
                                        if (!validationSet.contains(t)) {
                                            validationSet.add(t);
                                            if (buffer.length() != 0)
                                                buffer.append(",");
                                            buffer.append(t);
                                        } else {
                                            duplicateCounter.incrementAndGet();
                                        }
                                    });
                                })).join();

        long len = Arrays.stream(buffer.toString().split(","))
                .map(Integer::valueOf).count();

        System.out.println("Result: " + buffer.toString());
        System.out.println("Digits quantity in result: " + len + ", digits in validation set: " + validationSet.size() + ", duplicates: " + duplicateCounter.get());
    }

}
