package com.example.libraryApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "author", schema = "public")
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author") //um autor tem muitos livros
    private List<Book> books;

    @Deprecated
    public Author(){

    }
    public Author(UUID id, String name, LocalDate dateBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.nationality = nationality;
    }
}
