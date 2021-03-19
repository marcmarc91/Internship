package com.arobs.internship.library.repository;

import com.arobs.internship.library.mapper.BookMapper;
import com.arobs.internship.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookRepository implements GenericRepository<Book> {
    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insertQuery = "insert into book (title, author, date_added, tags, description) values (?,?,?,?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, book.getDateAdded());
            preparedStatement.setString(4, book.getTags());
            preparedStatement.setString(5, book.getDescription());
            return preparedStatement;
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            log.info("Key for the new book: {}", keyHolder.getKey().intValue());
            return keyHolder.getKey().intValue();
        } else {
            log.warn("KeyHolder is NULL");
            return 0;
        }
    }

    @Override
    public int update(int id, Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String updateQuery = "update book set title = ?, author = ?, date_added = ?, tags = ?, description = ? where id= ?";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, book.getDateAdded());
            preparedStatement.setString(4, book.getTags());
            preparedStatement.setString(5, book.getDescription());
            preparedStatement.setInt(5, id);
            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            log.info("Key for the modified book: {}", keyHolder.getKey().intValue());
            return keyHolder.getKey().intValue();
        } else {
            log.warn("KeyHolder is NULL");
            return 0;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from book where id = ?", id);
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query(
                "select * from book",
                new BookMapper()
        );
    }

    @Override
    public Book getById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from book where id = ?",
                    new BookMapper(),
                    id);
        } catch (EmptyResultDataAccessException exception) {
            log.debug("No record found in database for {}", id);
            return null;
        }
    }
}
