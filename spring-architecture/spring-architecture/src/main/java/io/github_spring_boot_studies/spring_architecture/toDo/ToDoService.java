package io.github_spring_boot_studies.spring_architecture.toDo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    public final ToDoRepository toDoRepository;
    private ToDoValidator toDoValidator;
    private MailSender mailSender;

    public ToDoService(ToDoRepository toDoRepository, ToDoValidator toDoValidator) {
        this.toDoRepository = toDoRepository;
        this.toDoValidator = toDoValidator;
    }

    public ToDoEntity save(ToDoEntity toDoEntity){
        toDoValidator.validate(toDoEntity);
        return toDoRepository.save(toDoEntity);
    }

    public ToDoEntity update(Integer id, ToDoEntity toDoEntity){
        ToDoEntity existingToDo = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo with ID: " + id + " not found."));

        toDoValidator.validate(toDoEntity);
        existingToDo.setDescription(toDoEntity.getDescription());
        existingToDo.setCompleted(toDoEntity.getCompleted());

        return toDoRepository.save(existingToDo);
    }

    public Optional<ToDoEntity> findById(Integer id){
        return toDoRepository.findById(id);
    }

    public List<ToDoEntity> findAll(){
        return toDoRepository.findAll();
    }
}
