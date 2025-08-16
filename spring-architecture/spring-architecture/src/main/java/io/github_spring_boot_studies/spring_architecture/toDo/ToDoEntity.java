package io.github_spring_boot_studies.spring_architecture.toDo;

import jakarta.persistence.*;

@Entity
@Table(name = "toDo")
public class ToDoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private Boolean completed;

    // Construtor padrão adicionado para o Hibernate
    public ToDoEntity() {
    }

    public ToDoEntity(Integer id, String description, Boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}