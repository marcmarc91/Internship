package com.arobs.repo;

import com.arobs.models.Author;
import com.arobs.utils.ConnectionType;
import com.arobs.utils.DataSource;
import com.arobs.utils.DatabaseConnection;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class AuthorRepository {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public AuthorRepository(ConnectionType connectionType) {
        if (connectionType.equals(ConnectionType.SINGLE)) {
            connection = DatabaseConnection.getConnection();
        } else {
            try {
                connection = DataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void addAuthor(Author author) {
        String insertQuery = "INSERT INTO author (name) values (?)";

        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, author.getName());
            preparedStatement.executeUpdate();
            System.out.printf("The author \"%s\" has been added.%n", author.getName());

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

    public Author getAuthorLikeName(String name) {
        String selectQuery = "SELECT * FROM author WHERE name LIKE ?";
        Author author = null;
        ResultSet res = null;
        try {
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, name);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                author = new Author(res.getInt("id_author"), res.getString("name"));
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return author;
    }


}
