package com.kodilla.multi.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class CountryInit {

    public static List<Country> initCountriesList() {
        File file = new File("module-3/src/main/resources/countries_population.csv");
        List<Country> countries = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(";");
                countries.add(new Country(arr[0], Long.parseLong(arr[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static List<Country> initBigList(int multipleSize) {
        List<Country> countries = initCountriesList();
        List<Country> list = new ArrayList<>();
        int var = 0;
        while (var<multipleSize) {
            var++;
            list.addAll(countries);
        }
        return list;
    }

}
