package com.kodilla.multi.task1;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Application {

    public static void main(String[] args) {
        List<Country> countries = CountryInit.initCountriesList();
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(new CountryProcessTask(countries));
        long endTime = System.currentTimeMillis();
        System.out.println("All population of " + countries.size() + " countries in 2019: " + result);
        System.out.println("Counting in parallel took: " + (endTime-startTime) + " [ms]");

        startTime = System.currentTimeMillis();
        result = countries.stream()
                .mapToLong(Country::getPopulationQuantity)
                .sum();
        endTime = System.currentTimeMillis();

        System.out.println("Counting in standard stream took: " + (endTime-startTime) + " [ms], result: " + result);

    }

}
