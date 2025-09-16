package com.javarchitect.hexagonal.simple.adapters;

import com.javarchitect.hexagonal.simple.domain.Task;
import com.javarchitect.hexagonal.simple.ports.input.TaskUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class RestAdapter {

    private final TaskUseCase taskUseCase;

    public RestAdapter(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    @PostMapping
    public Task create(@RequestParam String description) {
        return taskUseCase.createTask(description);
    }

    @PostMapping("/{id}/complete")
    public void complete(@PathVariable String id) {
        taskUseCase.completeTask(id);
    }
}

