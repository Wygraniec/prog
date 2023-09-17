package com.ToDoList;

import java.time.LocalDateTime;

public class Task {
    String name;
    String description;
    LocalDateTime dueDate;

    public Task(String name){ this(name, null); }
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
}
