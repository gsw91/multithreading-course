package com.kodilla.task.task1;

import com.kodilla.util.SleepUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Configuration {

    public void run() throws ExecutionException, InterruptedException {
        final FileGenerator fileGeneratorOne = new FileGenerator();
        final Future<String> resultA = fileGeneratorOne.generate(10);

        final FileGenerator fileGeneratorTwo = new FileGenerator();
        final Future<String> resultB = fileGeneratorTwo.generate(17);

        boolean checkA = true;
        boolean checkB = true;

        while (true) {
            SleepUtil.sleep(1);

            synchronized (Configuration.class) {
                checkA = checkStatus(FileGenerator.class, resultA, checkA, 10);
                checkB = checkStatus(FileGenerator.class, resultB, checkB, 17);
            }

            if (resultA.isDone() && resultB.isDone()) {
                System.out.println("All tasks completed: ");
                System.out.println("Task one completed of generator: " + resultA.get());
                System.out.println("Task two completed of Generator: " + resultB.get());
                break;
            }
        }

    }

    private boolean checkStatus(Class<?> clazz, Future<String> futureResult, boolean checkIt, int fileId) {
        if (!futureResult.isDone() && checkIt) {
            System.out.println(clazz.getSimpleName() + " still generating file " + fileId + ".txt...");
            return true;
        }
        return false;
    }

}
