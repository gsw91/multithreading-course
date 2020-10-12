package com.kodilla.task.task1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public final class FileGenerator {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void closeExecutor() {
        executor.shutdown();
    }

    public synchronized Future<String> generate(int fileId) {
        String fileName = fileId + ".txt";
        Random random = new Random();
        return executor.submit(() -> {
            System.out.println("Start generating file " + fileName);
            int delayTime = random.nextInt(20);
            sleep(delayTime);
            System.out.println("Task completed: generating file " + fileName);
            return "File " + fileName + " generated in " + delayTime + " s";
        });
    }

}
