package com.gradesManagement;

import com.loggers.*;

import java.util.LinkedList;
import java.util.List;

public class Grades {
    private final List<Grade> grades;
    private final Logger log;

    public Grades() {
        grades = new LinkedList<>();
        log = new ConsoleLogger();
    }
    public Grades(Logger log) {
        grades = new LinkedList<>();
        this.log = log;
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

    public Grade get(int index) {
        return grades.get(index);
    }

    public void update(int index, int grade) {
        grades.get(index).update(grade);
        log.information(String.format("Updated grade of id %d to grade %d", index, grade));
    }
    public void update(int index, int grade, int weight) {
        grades.get(index).update(grade, weight);
        log.information(String.format("Updated grade of id %d to grade %d and weight %d", index, grade, weight));
    }
    public void update(int index, int grade, int weight, String description) {
        grades.get(index).update(grade, description);
        log.information(String.format("Updated grade of id %d to grade %d, weight %d and description %s", index, grade, weight, description));
    }

    public void remove(int index) {
        grades.remove(index);
        log.information("Deleted grade of id " + index);
    }

    public float calculateAverage() {
        int sumOfWeights = grades.stream()
                .map(Grade::getWeight)
                .reduce(0, Integer::sum);

        int nominator = 0;
        for(Grade grade : grades)
            nominator += ( grade.getGrade() * grade.getWeight() );

        return (float)nominator / sumOfWeights;
    }

    @Override
    public String toString() {
        return grades.toString();
    }

}
