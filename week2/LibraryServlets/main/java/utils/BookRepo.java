package utils;

import model.Book;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class BookRepo {
    private static final Map<String, Book> books;
    private static BookRepo INSTANCE;

    private BookRepo() {
    }

    static {
        books = new HashMap<>();
        books.put("The Rose Code", new Book("The Rose Code", "Kate Quinn"));
        books.put("The Four Winds", new Book("The Four Winds", "Kristin Hannah"));
        books.put("Ulysses", new Book("Ulysses", "James Joyce"));
        books.put("Don Quixote", new Book("Don Quixote", "Miguel de Cervantes"));
        books.put("Moby Dick", new Book("Moby Dick", "Herman Melville"));
        books.put("Hamlet", new Book("Hamlet", "William Shakespeare"));
    }

    public static BookRepo getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookRepo();
        }
        return INSTANCE;
    }

    public Book getBookByTitile(String title) {
        Book book = null;
        if (books.containsKey(title)) {
            book = books.get(title);
        }
        return book;
    }

    public Map<String, Book> getAllBooks() {
        return books;
    }

    public void deleteBookByTitle(String title) {
        books.remove(title);
    }

    public void updateBookByTitle(String title, Book book) {
        if (books.containsKey(title)) {
            books.put(title, book);
        }
    }
}
