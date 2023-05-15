package com.No6_gradeManagementSystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.CrucialPackages.loggers.Logger;

/** Class representing a subject in school  */
public class Subject {
    private final String name;
    private String teacher;
    private final List<Grade> grades;
    private final Logger log;


    //---------------------------------------------------------------
    // Constructors
    //---------------------------------------------------------------

    /**
     * Constructs a Subject object with a given name
     * @param name Name of the subject
     * */
    public Subject(final String name){ this(name, null, null); }

    /**
     * Constructs a Subject object with a given name and a logger
     * @param name Name of the subject
     * @param log A class implementing the Logger interface where history of all the operations
     *            performed on grades will be logged
     * */
    public Subject(final String name, Logger log){ this(name, null, log); }

    /**
     * Constructs a Subject object with a given name and the name of a teacher
     * @param name Name of the subject
     * @param teacher The name of the teacher
     * */
    public Subject(final String name, final String teacher){ this(name, teacher, null); }

    /**
     * Constructs a Subject object with a given name, the name of a teacher and a logger
     * @param name Name of the subject
     * @param teacher The name of the teacher
     * @param log A class implementing the Logger interface where history of all the operations
     *      *            performed on grades will be logged
     * */
    public Subject(final String name, final String teacher, Logger log) {
        this.name = name;
        this.teacher = teacher;
        this.log = log;
        grades = new ArrayList<>();

        if(this.log != null)
            this.log.information("Created a Subject class object " + this);
    }


    //---------------------------------------------------------------
    // Getters
    //---------------------------------------------------------------


    public String getName() {
        return name;
    }
    public String getTeacher() {
        return teacher;
    }

    /**
     * Returns a grade of given ID
     * @param id ID of a desired grade in the system
     * @return Grade at a given ID
     * */
    public Grade getGrade(int id) {
        return grades.get(id);
    }


    //---------------------------------------------------------------
    // Modifying functions -> ones that contained within the class
    //---------------------------------------------------------------


    /**
     * Changes the name of the teacher for the subject
     * @param teacher Name of the new teacher
     * @throws IllegalArgumentException When the String is null or consists
     *                                  only of whitespace characters
     * */
    public void changeTeacher(String teacher) throws IllegalArgumentException {
        if(teacher == null || teacher.isBlank())
            throw new IllegalArgumentException("Teacher's name can't be empty");

        this.teacher = teacher;

        if(log != null)
            log.information("Changed the teacher to " + teacher);

    }

    /**
     * Adds a new grade to the system
     * @param grade Grade to be added
     * @return Instance of class on which the method was invoked
     * */
    public Subject addGrade(Grade grade){
        grades.add(grade);

        if(log != null)
            log.information("Added new grade to the system " + grade);

        return this;
    }

    /**
     * Removes grade of a given ID
     * @param id ID of the grade which is to be deleted
     * @return Instance of class on which the method was invoked
     * */
    public Subject removeGrade(int id) {
        Grade temp = grades.get(id);
        grades.remove(id);

        if(log != null)
            log.information("Removed the following grade from the system " + temp );

        return this;
    }

    /**
     * Modifies the description of a grade
     * @param id ID of a grade whose description shall be changed
     * @param description The new description of a grade
     * @return Instance of a class on which the method was invoked
     * */
    public Subject modifyGradesDescription(int id, String description) {
        if(log != null)
            log.information(String.format("Modified the %s's description to %s", grades.get(id), description));

        grades.get(id).updateDescription(description);
        return this;
    }

    /**
     * Modifies the description of a grade
     * @param id ID of a grade whose description shall be changed
     * @param grade The new grade's value
     * @return Instance of a class on which the method was invoked
     * */
    public Subject modifyGradesGrade(int id, int grade) {
        if(log != null)
            log.information(String.format("Modified the %s's grade to %d", grades.get(id), grade));

        grades.get(id).updateGrade(grade);
        return this;
    }

    /**
     * Modifies the description of a grade
     * @param id ID of a grade whose description shall be changed
     * @param weight The new grade's weight
     * @return Instance of a class on which the method was invoked
     * */
    public Subject modifyGradesWeight(int id, int weight) {
        if(log != null)
            log.information(String.format("Modified the %s's weight to %d", grades.get(id), weight));

        grades.get(id).updateWeight(weight);
        return this;
    }

    //---------------------------------------------------------------
    // Utility functions -> ones that perform operations on the data
    //---------------------------------------------------------------

    /**
     * Method calculating a weighted average of grades
     * @return Weighted average of grades stored in a container within the class
     *          Rounded to the 2nd place after comma
     * */
    public double calculateAverage() {
        int weightedSum = grades.stream()
                .mapToInt( g -> g.getWeight() *  g.getGrade() )
                .sum();

        int sumOfWeights = grades.stream()
                .mapToInt(Grade::getWeight)
                .sum();

        return Double.parseDouble(
                new DecimalFormat("#.##")
                        .format( (double)weightedSum / sumOfWeights )
        );
    }

    /**
     * Prints the current grades to the standard output
     * */
    public void printGrades(){
        System.out.println();
        grades.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Subject { name = ").append(name);

        if(teacher != null)
            string.append(", teacher = ").append(teacher);

        return string.append(" }").toString();
    }

}
