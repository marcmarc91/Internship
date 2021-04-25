package com.arobs.internship.library.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors = new ArrayList<>();

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.LAZY)
    @JoinTable(name = "book_tag",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags = new ArrayList<>();

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    @OneToMany(
            mappedBy = "book",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<BookRent> bookRents;

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public void addTag(Tag tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setBookRents(Set<BookRent> bookRents) {
        this.bookRents = bookRents;
    }

    public Set<BookRent> getBookRents() {
        return bookRents;
    }
}