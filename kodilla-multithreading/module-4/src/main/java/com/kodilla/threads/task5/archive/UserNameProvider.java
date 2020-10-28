package com.kodilla.threads.task5.archive;

import java.util.concurrent.CompletableFuture;

public class UserNameProvider {

    public CompletableFuture<String> provideUsersName(int id) {

        System.out.println("Providing user of id: " + id);
        return CompletableFuture.supplyAsync(() -> {
            switch (id) {
                case 1:
                case 6:
                case 10:
                    return "Username1";
                case 2:
                    return "Username2";
                case 3:
                case 5:
                    return "Username3";
                case 4:
                    return "Username4";
                case 7:
                    return "Username6";
                case 8:
                    return "Username8";
                case 9:
                    return "Username7";
                default:
                    throw new RuntimeException("There is no user of id " + id);
            }
        });
    }

}
