package com.No5_grades.gradesManagement;

import com.No5_grades.loggers.ConsoleLogger;
import com.No5_grades.loggers.Logger;

import java.util.LinkedList;
import java.util.List;

public class Subject {
    private final List<Grade> grades = new LinkedList<>();
    String teacher;
    String name;
    private final Logger log;

    public Subject(String subject, String teacher) {
        this(subject, teacher, new ConsoleLogger());
    }
    public Subject(String subject, String teacher, Logger log) {
        this.log = log;
        this.teacher = teacher;
        this.name = subject;
    }

    public void add(Grade grade) {
        grades.add(grade);
        log.information(String.format("Added grade %d with weight %d", grade.getGrade(), grade.getWeight()));
    }
    public void add(int grade, int weight) {
        grades.add( new Grade(grade, weight) );
        log.information(String.format("Added grade %d with weight %d", grade, weight));
    }
    public void add(int grade, int weight, String description) {
        grades.add( new Grade(grade, weight, description) );
        log.information(String.format("Added grade %d with weight %d", grade, weight));
    }

    public Grade get(int index) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        return grades.get(index);
    }

    public void update(int index, int grade) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.get(index).update(grade);
        log.information(String.format("Updated grade of id %d to grade %d",
                index, grade));
    }
    public void update(int index, int grade, int weight) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.get(index).update(grade, weight);
        log.information(String.format("Updated grade of id %d to grade %d and weight %d",
                index, grade, weight));
    }
    public void update(int index, int grade, int weight, String description) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.get(index).update(grade, description);
        log.information(String.format("Updated grade of id %d to grade %d, weight %d and description %s",
                index, grade, weight, description));
    }
    public void update(int index, Grade grade) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.set(index, grade);
        log.information(String.format("Updated grade of id %d to grade %s",
                index, grade));
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.remove(index);
        log.information("Deleted grade of id " + index);
    }

    public double calculateAverage() {
        int totalWeight = grades.stream()
                .mapToInt( Grade::getWeight )
                .sum();

        double weightedSum = grades.stream()
                .mapToDouble( grade -> grade.getGrade() * grade.getWeight() )
                .sum();

        return weightedSum / totalWeight;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Teacher: ");
        builder.append(teacher).append("\nSubject: ").append(name);
        builder.append('\n').append(grades);

        return builder.toString();
    }
}