package io.github_spring_boot_studies.spring_architecture.toDo;

import org.springframework.stereotype.Component;

@Component
public class ToDoValidator {

    private ToDoRepository toDoRepository;

    public ToDoValidator(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    public void validate(ToDoEntity toDoEntity){
        if(existsByDescription((toDoEntity.getDescription()))){
            throw new IllegalArgumentException("There is already a toDo with this description. Rename and try again.");
        }
    }
    private boolean existsByDescription(String description){
        return toDoRepository.existsByDescription(description);
    }
}
