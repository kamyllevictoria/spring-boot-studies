package com.example.libraryApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 50, nullable = false)
    private BookGender gender;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @ManyToOne //muitos livros para um autor
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    @Deprecated
    public Book(){}

    public Book(UUID id, String isbn, String title, LocalDate publicationDate, String gender, Double price, Integer pages) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.gender = BookGender.valueOf(gender);
        this.price = price;
        this.pages = pages;
    }
}
