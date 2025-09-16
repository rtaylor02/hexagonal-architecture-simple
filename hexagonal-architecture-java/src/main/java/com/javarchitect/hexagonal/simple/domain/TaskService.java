package com.javarchitect.hexagonal.simple.domain;

import com.javarchitect.hexagonal.simple.ports.input.TaskUseCase;
import com.javarchitect.hexagonal.simple.ports.output.NotificationService;
import com.javarchitect.hexagonal.simple.ports.output.TaskRepository;

import java.util.UUID;

public class TaskService implements TaskUseCase {

    private final TaskRepository taskRepository;
    private final NotificationService notificationService;

    public TaskService(TaskRepository taskRepository, NotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
    }

    @Override
    public Task createTask(String description) {
        Task task = new Task(UUID.randomUUID().toString(), description);
        taskRepository.save(task);
        notificationService.notify("Task created: " + task.getDescription());
        return task;
    }

    @Override
    public void completeTask(String taskId) {
        Task task = taskRepository.findById(taskId);
        task.markCompleted();
        taskRepository.save(task);
        notificationService.notify("Task completed: " + task.getDescription());
    }
}

