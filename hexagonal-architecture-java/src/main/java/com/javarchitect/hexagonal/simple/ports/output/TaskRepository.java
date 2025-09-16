package com.javarchitect.hexagonal.simple.ports.output;

import com.javarchitect.hexagonal.simple.domain.Task;

public interface TaskRepository {
    Task save(Task task);
    Task findById(String id);
}
