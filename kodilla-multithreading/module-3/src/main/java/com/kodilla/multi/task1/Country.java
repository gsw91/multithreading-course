package com.kodilla.multi.task1;

import java.util.Objects;

public final class Country {

    private final String name;
    private final long populationQuantity;

    public Country(final String name, final long population) {
        this.name = name;
        this.populationQuantity = population;
    }

    public String getName() {
        return name;
    }

    public long getPopulationQuantity() {
        return populationQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + populationQuantity +
                '}';
    }

}
