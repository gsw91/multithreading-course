package com.kodilla.multi.task4;

import java.util.Random;
import java.util.concurrent.Exchanger;

public final class BookExchProducer implements Runnable {

    private final Exchanger<Book> exchanger;
    private final int bookQuantity;

    public BookExchProducer(Exchanger<Book> exchanger, int bookQuantity) {
        this.exchanger = exchanger;
        this.bookQuantity = bookQuantity;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i=0; i<bookQuantity; i++) {
                Thread.sleep(random.nextInt(2000));
                Book book = new Book(
                        "Book_" + random.nextInt(100),
                        "Author_" + random.nextInt(100)
                );
                System.out.println("Producer: book ready!");
                exchanger.exchange(book);
            }
            Book closingToken = new Book(Book.CLOSING_NAME, Book.CLOSING_TOKEN);
            exchanger.exchange(closingToken);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
