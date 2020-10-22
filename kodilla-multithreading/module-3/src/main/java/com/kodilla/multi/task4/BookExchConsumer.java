package com.kodilla.multi.task4;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BookExchConsumer implements Runnable {

    private final Exchanger<Book> exchanger;

    public BookExchConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
       while(true) {
           try {
               Book book = exchanger.exchange(null, 500, TimeUnit.MILLISECONDS);
               if (book.getName().equals(Book.CLOSING_NAME) && book.getAuthor().equals(Book.CLOSING_TOKEN)) {
                   System.out.println("Consumer: All books received!");
                   break;
               }
               System.out.println("Consumer: Received book: " + book);
           } catch (InterruptedException | TimeoutException e) {
               System.out.println("Consumer: Waiting for message... " + e.getLocalizedMessage());
           }
       }
    }

}
