package com.arobs.internship.library.mapper;

import com.arobs.internship.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    private static final Logger log = LoggerFactory.getLogger(BookMapper.class);

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setDescription(resultSet.getString("description"));
        book.setTags(resultSet.getString("tags"));
        book.setDateAdded(resultSet.getDate("date_added"));

        return book;
    }
}
