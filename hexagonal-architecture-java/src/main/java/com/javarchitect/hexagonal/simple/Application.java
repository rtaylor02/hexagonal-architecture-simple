package com.javarchitect.hexagonal.simple;

import com.javarchitect.hexagonal.simple.adapters.CliAdapter;
import com.javarchitect.hexagonal.simple.domain.TaskService;
import com.javarchitect.hexagonal.simple.ports.input.TaskUseCase;
import com.javarchitect.hexagonal.simple.ports.output.ConsoleNotificationService;
import com.javarchitect.hexagonal.simple.ports.output.InMemoryTaskRepository;
import com.javarchitect.hexagonal.simple.ports.output.NotificationService;
import com.javarchitect.hexagonal.simple.ports.output.TaskRepository;

public class Application {
    public static void main(String[] args) {
        TaskRepository repository = new InMemoryTaskRepository();
        NotificationService notification = new ConsoleNotificationService();
        TaskUseCase taskService = new TaskService(repository, notification);

        // CLI example
        CliAdapter cli = new CliAdapter(taskService);
        cli.run();

        // For REST, Spring Boot would autowire `taskService` into `RestAdapter`
    }
}

