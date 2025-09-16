package com.javarchitect.hexagonal.simple.ports.output;

import com.javarchitect.hexagonal.simple.domain.Task;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<String, Task> store = new HashMap<>();

    @Override
    public Task save(Task task) {
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return store.get(id);
    }
}

