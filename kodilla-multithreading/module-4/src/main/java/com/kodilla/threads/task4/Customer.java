package com.kodilla.threads.task4;

import java.util.Objects;

public final class Customer {

    private final int id;
    private final String name;
    private final String addBy;
    private final String archivedBy;

    public Customer(int id, String name, String addBy, String archivedBy) {
        this.id = id;
        this.name = name;
        this.addBy = addBy;
        this.archivedBy = archivedBy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddBy() {
        return addBy;
    }

    public String getArchivedBy() {
        return archivedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addBy='" + addBy + '\'' +
                ", archivedBy='" + archivedBy + '\'' +
                '}';
    }

}
