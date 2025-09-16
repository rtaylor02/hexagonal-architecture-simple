package com.javarchitect.hexagonal.simple.ports.input;

import com.javarchitect.hexagonal.simple.domain.Task;

public interface TaskUseCase {
    Task createTask(String description);
    void completeTask(String taskId);
}

