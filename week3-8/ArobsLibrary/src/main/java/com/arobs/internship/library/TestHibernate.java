package com.arobs.internship.library;

import com.arobs.internship.library.config.HibernateConfig;
import com.arobs.internship.library.entity.*;
import com.arobs.internship.library.entity.types.RoleType;
import com.arobs.internship.library.entity.types.StatusBookRent;
import com.arobs.internship.library.entity.types.StatusCopy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TestHibernate {
    private static final Logger log = LoggerFactory.getLogger(TestHibernate.class);

    private Session session;
    private Transaction transaction;

    public TestHibernate() {
        session = HibernateConfig.getSession();
        resetTables();
    }

    public void addBook() {
        transaction = session.beginTransaction();

        Author craigAuthor = new Author();
        craigAuthor.setName("Craig Walls");

        Author alexAuthor = new Author();
        alexAuthor.setName("Alex Anton");

        Tag tagJava = new Tag();
        tagJava.setWord("java");

        Tag tagSpring = new Tag();
        tagSpring.setWord("spring");

        List<Copy> copyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Copy copy = new Copy();
            if ((i % 2) == 0) {
                copy.setFlag(true);
                copy.setStatus(StatusCopy.AVAILABLE);
            } else {
                copy.setFlag(false);
                copy.setStatus(StatusCopy.RENTED);
            }
            copyList.add(copy);
        }

        Book book = new Book();
        book.setTitle("Spring Boot in action");
        book.getAuthors().add(craigAuthor);
        book.getAuthors().add(alexAuthor);
        book.getTags().add(tagJava);
        book.getTags().add(tagSpring);
//        book.setCopies(copyList);
        book.setDescription("Spring Boot in Action is a developer-focused guide to writing applications using Spring Boot.");
//        book.setDateAdded(new Date(System.currentTimeMillis()));

        Employee will_john = createEmployee("Will John");

        BookRent bookRent = new BookRent();
//        bookRent.setCopy(book.getCopies().get(0));
        bookRent.setBook(book);
        bookRent.setEmployee(will_john);
        bookRent.setRentalDate(LocalDateTime.now().plusMonths(1));
        bookRent.setStatus(StatusBookRent.ON_GOING);

        session.save(bookRent);
        transaction.commit();

//        getBook(id);

    }

    public void getBook(int id) {
        transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);
        transaction.commit();

        System.out.printf("Book description: " +
                        "%n ID: %s; " +
                        "%n TITLE: %s; " +
                        "%n AUTHORS: %s; " +
                        "%n DESCRIPTION: %s; " +
                        "%n TAGS: %s; " +
                        "%n COPIES: %s; " +
                        "%n DATE: %s;%n",
                book.getId(),
                book.getTitle(),
                book.getAuthors().stream().map(Author::getName).reduce((a1, a2) -> a1 + ", " + a2),
                book.getDescription(),
                book.getTags().stream().map(Tag::getWord).reduce((t1, t2) -> t1 + ", " + t2),
//                book.getCopies(),
                book.getDateAdded());


    }

    public Employee createEmployee(java.lang.String name) {
        Employee employee = new Employee();
        employee.setEmail(name.toLowerCase().replaceAll(" ", ".") + "@arobs.com");
        employee.setName(name);
        employee.setPassword("12345");
        employee.setRole(RoleType.REGULAR);
        return employee;
    }


    public void resetTables() {
        transaction = session.beginTransaction();

        session.createQuery("delete from author").executeUpdate();
        session.createQuery("delete from book").executeUpdate();
        session.createQuery("delete from bookRent").executeUpdate();
        session.createQuery("delete from bookRequest").executeUpdate();
        session.createQuery("delete from copy").executeUpdate();
        session.createQuery("delete from employee").executeUpdate();
        session.createQuery("delete from rentRequest").executeUpdate();
        session.createQuery("delete from tag").executeUpdate();

        transaction.commit();
    }
}
