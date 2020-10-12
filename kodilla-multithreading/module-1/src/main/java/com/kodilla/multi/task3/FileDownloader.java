package com.kodilla.multi.task3;

import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public final class FileDownloader implements Runnable {

    private final WebClientMock webClientMock;
    private static int documentNextId;
    private static int semaphoreCounter;
    private final static Semaphore semaphore = new Semaphore(10);

    public FileDownloader(WebClientMock webClientMock) {
        this.webClientMock = webClientMock;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            processData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public void processData() throws InterruptedException {
        int fileId;
        synchronized (FileDownloader.class) {
            semaphoreCounter++;
            documentNextId++;
            fileId = documentNextId;
            System.out.println("Loading document " + fileId + " by thread " + Thread.currentThread().getName() + ", connections qty: " + semaphoreCounter);
        }
        String file = webClientMock.getResponse(fileId, LocalDate.now());
        System.out.println("Document " + fileId + " is downloaded: " + file);
        synchronized (FileDownloader.class) {
            semaphoreCounter--;
        }

    }

}
