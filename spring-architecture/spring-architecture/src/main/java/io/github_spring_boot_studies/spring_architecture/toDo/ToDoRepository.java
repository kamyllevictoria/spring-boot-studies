package io.github_spring_boot_studies.spring_architecture.toDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {
    boolean existsByDescription(String description);
}
