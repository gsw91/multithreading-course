package com.kodilla.completable.homework;

import java.util.Objects;

public final class Book {

    private final String title;
    private final String author;
    private final String year;
    private String signature;

    public Book(final String title, final String author, final String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.year = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isEmpty() {
        return title == null && author == null && year == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                year.equals(book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

}
