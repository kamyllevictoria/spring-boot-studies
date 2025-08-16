package io.github_spring_boot_studies.spring_architecture.toDo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("toDo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping()
    public ToDoEntity save(@RequestBody ToDoEntity toDoEntity){
        return toDoService.save(toDoEntity);
    }

    @PutMapping("/{id}")
    public ToDoEntity update(@PathVariable("id") Integer id, @RequestBody ToDoEntity toDoEntity){
        try{
            return this.toDoService.update(id, toDoEntity);
        } catch (IllegalArgumentException e){
            var msgError = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, msgError);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentError(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}")
    public Optional<ToDoEntity> getById(@PathVariable("id") Integer id){
        return toDoService.findById(id);
    }

    @GetMapping
    public List<ToDoEntity> getAll(){
        return toDoService.findAll();
    }
}
