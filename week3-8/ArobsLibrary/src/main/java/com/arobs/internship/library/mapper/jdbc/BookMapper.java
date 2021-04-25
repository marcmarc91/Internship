package com.arobs.internship.library.mapper.jdbc;

import com.arobs.internship.library.model_jdbc.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    private static final Logger log = LoggerFactory.getLogger(BookMapper.class);

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book bookDto = new Book();
        bookDto.setId(resultSet.getInt("id"));
        bookDto.setTitle(resultSet.getString("title"));
        bookDto.setAuthor(resultSet.getString("author"));
        bookDto.setDescription(resultSet.getString("description"));
        bookDto.setTags(resultSet.getString("tags"));
        bookDto.setDateAdded(resultSet.getDate("date_added"));

        return bookDto;
    }
}
