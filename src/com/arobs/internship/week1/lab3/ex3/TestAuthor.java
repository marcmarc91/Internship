package com.arobs.internship.week1.lab3.ex3;

public class TestAuthor {
    public TestAuthor() {
        Author author = new Author("John Peter", "john.peter@example.com", 'm');

        System.out.printf("Name: %s%n", author.getName());
        System.out.printf("Gender: %s%n", author.getGender());
        System.out.printf("Email: %s%n", author.getEmail());

        author.setEmail("peter.john@example.com");
        System.out.println(author);
    }
}
