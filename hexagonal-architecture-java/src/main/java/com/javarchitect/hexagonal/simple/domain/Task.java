package com.javarchitect.hexagonal.simple.domain;

public class Task {
    private final String id;
    private final String description;
    private boolean completed;

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

