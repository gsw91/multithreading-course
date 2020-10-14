package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.kodilla.util.SleepUtil.sleep;

public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Book> futureBook = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Loading book...");
                    sleep(4);
                    return new Book("Java Multithreading Coure", "Kodilla Kodilla", "2020");
                    //return new Book("Java Multithreading Coure", "Kodilla Kodilla", "");
                })
                .thenApply(t -> {
                    if (t.getAuthor() == null || t.getAuthor().isBlank()
                            || t.getTitle() == null || t.getTitle().isBlank()
                            || t.getYear() == null || t.getYear().isBlank()) {
                        throw new NullPointerException("Some required fields are empty in object: Book");
                    }
                    return t;
                })
                .exceptionally(t -> {
                    System.out.println("Error when fetching the book: " + t.getMessage());
                    return new Book();
                })
                .thenApply(t -> {
                    if (!t.isEmpty()) {
                        System.out.println("Setting signature...");
                        sleep(2);
                        t.setSignature("GSW");
                        return t;
                    }
                    System.out.println("Setting signature failed");
                    return t;
                });

        CompletableFuture<Void> cfVoid = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                sleep(1);
                System.out.println("Other opeartion done: " + i);
            }
        });

        futureBook
                .thenAccept(t -> {
                    if (t.isEmpty())
                        System.out.println("Book not found!");
                    else
                        System.out.println("Your book: " + t);
                })
                .get();

        cfVoid.get();

    }

}
