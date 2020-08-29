package com.company;

import java.util.ArrayList;

public class Streams {

    public static void main(String[] args) {
        ArrayList<Book> books = populateLibrary();
        books.stream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).filter(book -> {
            return book.getTitle().startsWith("T");
        }).forEach(System.out::println);
    }

    static ArrayList<Book> populateLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Jack London", "The Call of The Wild"));
        books.add(new Book("Jane Austen", "The Beautiful Cassandra"));
        books.add(new Book("Toni Morrison", "Meridian"));
        books.add(new Book("Ernest Hemingway", "The Old Man and The Sea"));
        books.add(new Book("Haruki Murakami", "Norwegian Wood"));
        books.add(new Book("George Orwell", "Animal Farm"));
        books.add(new Book("Jane Austen", "Pride and Prejudice"));
        return books;
    }
}
