package com.kodilla.multi.task1;

import com.kodilla.multi.parallel.Book;
import com.kodilla.multi.parallel.BookProcessTask;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public final class CountryProcessTask extends RecursiveTask<Long> {

    private final List<Country> countries;

    public CountryProcessTask(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        if (countries.size() <= 10) {
            return countries
                    .stream()
                    .mapToLong(Country::getPopulationQuantity)
                    .sum();
        } else {
            int part = countries.size() / 2;
            CountryProcessTask left = new CountryProcessTask(countries.subList(0, part));
            CountryProcessTask right = new CountryProcessTask(countries.subList(part, countries.size()));
            left.fork();
            long rightResult = right.compute();
            long leftResult = left.join();
            return leftResult + rightResult;
        }
    }

}


