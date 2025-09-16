package com.javarchitect.hexagonal.simple.adapters;

import com.javarchitect.hexagonal.simple.domain.Task;
import com.javarchitect.hexagonal.simple.ports.input.TaskUseCase;

public class CliAdapter {
    private final TaskUseCase taskUseCase;

    public CliAdapter(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    public void run() {
        Task task = taskUseCase.createTask("Follow JavaRchitect's hexagonal architecture code");
        taskUseCase.completeTask(task.getId());
    }
}

