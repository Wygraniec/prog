package com.No5_grades.gradesManagement;

import com.No5_grades.loggers.Logger;
import com.No5_grades.loggers.ConsoleLogger;

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

    public void remove(int index) throws IndexOutOfBoundsException {
        if( index < 0 || index >= grades.size() ) {
            log.error("IndexOutOfBoundException - tried referring to an index that does not exist");
            throw new IndexOutOfBoundsException();
        }

        grades.remove(index);
        log.information("Deleted grade of id " + index);
    }

    public float calculateAverage() {
        int totalWeight = grades.stream()
                .map(Grade::getWeight)
                .reduce(0, Integer::sum);

        int weightedSum = grades.stream()
                .mapToInt( grade -> grade.getGrade() * grade.getWeight() )
                .sum();

        return (float)weightedSum / totalWeight;

    }

    @Override
    public String toString() {
        return grades.toString();
    }

}
