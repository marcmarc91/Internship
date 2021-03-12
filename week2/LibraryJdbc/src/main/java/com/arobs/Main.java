package com.arobs;

import com.arobs.models.Author;
import com.arobs.models.Book;
import com.arobs.repo.BookRepository;
import com.arobs.utils.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        BookRepository bookRepository = new BookRepository();

        //create author
        Author author = new Author();
        author.setId(9);
        author.setName("Vladimir Nabokov");

        //insert new book and new author
        Book book = new Book(9, "Lolita", new Date(System.currentTimeMillis()), 23.53f, author);
        bookRepository.addBook(book);

        //get book by title
        Book bookById = bookRepository.getBookByTitle("Hamlet");
        System.out.println(bookById);

        //get book by author
        Book bookByAuthor = bookRepository.getBookByAuthor(author);

        //get list with all books
        List<Book> books = bookRepository.getAllBooks();
        System.out.printf("%s records.%n", books.size());
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%s. %s;%n", i+1, books.get(i));
        }

        //update book
        book.setPrice(28.2f);
        bookRepository.updateBook(book,30);

        //delete book
        bookRepository.deleteBookById(32);

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
