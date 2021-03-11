package com.arobs.internship.week1.lab4.ex2;

public class TestAuthor {
    private Author author;

    public TestAuthor(Author author) {
        this.author = author;
    }

    public void displayInfo() {
        System.out.printf("Name: %s%n", author.getName());
        System.out.printf("Gender: %s%n", author.getGender());
        System.out.printf("Email: %s%n", author.getEmail());

        author.setEmail("peter.john@example.com");

        System.out.println(author);
    }
}
