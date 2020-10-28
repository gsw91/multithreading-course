package com.kodilla.threads.task5.archive;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UserIdProvider {

    public CompletableFuture<List<Integer>> provideUsersId() {
        System.out.println("Providing users");
        return CompletableFuture.supplyAsync(() -> List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

}
