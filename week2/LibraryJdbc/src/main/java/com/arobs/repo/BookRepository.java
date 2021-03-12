package com.arobs.repo;

import com.arobs.models.Author;
import com.arobs.models.Book;
import com.arobs.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

    public BookRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addBook(Book book) {
        String insertQuery = "INSERT INTO book (id_author, title, publish_date, price) values (?,?,?,?)";
        String checkAuthorQuery = "SELECT * FROM author WHERE id_author =" + book.getAuthor().getId();

        try {
            boolean existAuthor = true;
            statement = connection.createStatement();
            if (!statement.executeQuery(checkAuthorQuery).next()) {
                preparedStatement = connection.prepareStatement("INSERT INTO author value (?,?)");
                preparedStatement.setInt(1, book.getAuthor().getId());
                preparedStatement.setString(2, book.getAuthor().getName());
                if (preparedStatement.executeUpdate() == 0) {
                    existAuthor = false;
                }
            }
            if (existAuthor) {
                preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, book.getAuthor().getId());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setDate(3, book.getPublishDate());
                preparedStatement.setFloat(4, book.getPrice());
                int i = preparedStatement.executeUpdate();
                System.out.printf("%s records", i);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public Book getBookByTitle(String title) {
        String selectQuery = "SELECT * FROM book WHERE title=\"" + title + "\"";
        Book book = null;
        try {
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(selectQuery);
            book = new Book();
            if (res.next()) {
                book.setId(res.getInt("id_book"));
                book.setPrice(res.getFloat("price"));
                book.setTitle(res.getString("title"));
                book.setPublishDate(res.getDate("publish_date"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return book;
    }

    public Book getBookByAuthor(Author author) {
        Book book = null;
        String joinQuery =
                "SELECT id_book, title, price, publish_date as publish " +
                        "FROM author " +
                        "RIGHT JOIN book " +
                        "ON author.id_author = book.id_author " +
                        "where author.id_author= ? ";
        try {
            preparedStatement = connection.prepareStatement(joinQuery);
            preparedStatement.setInt(1, author.getId());
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                book = new Book();
                book.setId(res.getInt("id_book"));
                book.setPrice(res.getFloat("price"));
                book.setTitle(res.getString("title"));
                book.setPublishDate(res.getDate("publish"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return book;
    }

    public List<Book> getAllBooks() {
        String selectQuery =
                "SELECT id_book, title, price, publish_date as publish, name, author.id_author " +
                        "FROM author " +
                        "RIGHT JOIN book " +
                        "ON author.id_author = book.id_author";
        List<Book> books = null;
        ResultSet res = null;
        try {
            statement = connection.createStatement();
            res = statement.executeQuery(selectQuery);
            books = new ArrayList<>();
            while (res.next()) {
                books.add(new Book(
                        res.getInt("id_book"),
                        res.getString("title"),
                        res.getDate("publish"),
                        res.getFloat("price"),
                        new Author(res.getInt("id_author"), res.getString("name"))));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return books;
    }

    public void deleteBookById(int id) {
        String deleteQuery = "DELETE FROM book WHERE id_book = ? ";
        try {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.printf("%s records deleted.%n", i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void updateBook(Book book, int id) {
        String updateQuery =
                "UPDATE book " +
                        "SET title= ?, price= ?, publish_date= ?, id_author= ? " +
                        "WHERE id_book = ?";
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setDate(3, book.getPublishDate());
            preparedStatement.setInt(4, book.getAuthor().getId());
            preparedStatement.setInt(5, id);
            int i = preparedStatement.executeUpdate();
            System.out.printf("%s record updated.%n", i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
