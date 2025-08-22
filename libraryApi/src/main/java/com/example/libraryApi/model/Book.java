package com.example.libraryApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "tittle", length = 150, nullable = false)
    private String tittle;

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "pages", nullable = false)
    private Integer pages;

}
