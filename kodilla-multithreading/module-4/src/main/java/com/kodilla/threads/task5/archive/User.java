package com.kodilla.threads.task5.archive;

public class User {

    private final int id;
    private final String name;
    private final String surname;
    private final String fullName;

    public User(int id, String name, String surname, String fullName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}
