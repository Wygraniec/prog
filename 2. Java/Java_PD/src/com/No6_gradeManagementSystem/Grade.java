package com.No6_gradeManagementSystem;

import java.time.LocalDateTime;

/**
 * Class representing a school grade
 * */
public class Grade {
    private Integer grade;
    private Integer weight;
    private String description;
    private final LocalDateTime addedAt;
    private LocalDateTime updatedAt;
    /**
     * Constructor creating a new grade with default weight 1 and no description
     * @param grade grade to be added
     * */
    public Grade(int grade){ this(grade, 1, null); }
    /**
     * Constructor creating a new grade with no description
     * @param grade grade to be added
     * @param weight weight of the new grade
     * */
    public Grade(int grade, int weight){ this(grade, weight, null); }
    /**
     * Constructor creating a new grade with provided details
     * @param grade grade to be added
     * @param weight weight of the new grade
     * @param description description of a new grade
     * */
    public Grade(int grade, int weight, String description) {
        this.grade = grade;
        this.weight = weight;

        if(description != null)
            this.description = description;

        addedAt = LocalDateTime.now();
    }

    public Integer getGrade() { return grade; }
    public Integer getWeight() { return weight; }
    public String getDescription() { return description; }

    /**
     * Updates the grade with the provided value
     * @param grade new grade
     * @return the instance of a Grade class on which the method was called
     * */
    public Grade updateGrade(int grade){
        this.grade = grade;
        updatedAt = LocalDateTime.now();
        return this;
    }
    /**
     * Updates the weight with the provided value
     * @param weight new weight
     * @return the instance of a Grade class on which the method was called
     * */
    public Grade updateWeight(int weight){
        this.weight = weight;
        updatedAt = LocalDateTime.now();
        return this;
    }
    /**
     * Updates the description with the provided value
     * @param description new description
     * @return the instance of a Grade class on which the method was called
     * */
    public Grade updateDescription(String description){
        this.description = description;
        updatedAt = LocalDateTime.now();
        return this;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(80);

        string.append("Grade{ grade=").append(grade).
                append(", weight=").append(weight);

        if(description != null)
            string.append(", description=").append(description);

        string.append(", addedAt=").append(addedAt);

        if(updatedAt != null)
            string.append(", updatedAt=").append(updatedAt);

        return string.append(" }").toString();
    }
}
