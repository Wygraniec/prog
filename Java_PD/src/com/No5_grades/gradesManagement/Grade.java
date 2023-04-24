package com.No5_grades.gradesManagement;

import java.time.LocalDateTime;

public class Grade {
    private int grade;
    private int weight;
    String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Grade(int grade, int weight) {
        this.grade = grade;
        this.weight = weight;
        createdAt = LocalDateTime.now();
    }
    public Grade(int grade, int weight, String description) {
        this.grade = grade;
        this.weight = weight;
        this.description = description;
        createdAt = LocalDateTime.now();
    }

    public int getGrade() { return grade; }
    public int getWeight() { return weight; }
    public String getDescription() { return description; }

    public void update(int grade) {
        this.grade = grade;
        updatedAt = LocalDateTime.now();
    }
    public void update(int grade, int weight) {
        this.grade = grade;
        this.weight = weight;
        updatedAt = LocalDateTime.now();
    }
    public void update(int grade, String description) {
        this.grade = grade;
        this.description = description;
        updatedAt = LocalDateTime.now();
    }
    public void update(int grade, int weight, String description) {
        this.grade = grade;
        this.weight = weight;
        this.description = description;
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\nGrade: " + grade + "\nWeight: " + weight);

        if(description != null)
            builder.append("\nDescription: ").append(description);

        builder.append("\nCreation date: ").append(createdAt);

        if(updatedAt != null)
            builder.append("\nLast update date: ").append(updatedAt);

        return builder.append('\n').toString();
    }
}
