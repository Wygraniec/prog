package com.No6_gradeManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static void printMenu() {
        System.out.println("0. Exit the app");
        System.out.println("1. Add new subject");
        System.out.println("2. Print grades from specific subject");
        System.out.println("3. Modify a grade from a specific subject");
        System.out.println("4. Print all the added subjects");
        System.out.println("5. Add new grade to a subject");
        System.out.println("6. Delete a subject");
        System.out.println("7. Calculate average from a subject");
        System.out.print("Choice: ");
    }
    static void addNewSubjectToMap(Map<String, Subject> dict) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the subject's name: ");
        String name = stdin.nextLine().trim().toLowerCase();

        if(dict.containsKey(name)) {
            System.out.println("The subject has already been added");
            return;
        }

        System.out.print("Enter the teacher's name: ");
        String teacher = stdin.nextLine().trim();

        dict.put( name, new Subject(name, teacher) );
    }
    static void printGradesFromSubjectFromDictionary(Map<String, Subject> dict) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the name of a subject: ");
        String name = stdin.nextLine().trim().toLowerCase();

        if(!dict.containsKey(name)) {
            System.out.println("Such subject has not been added");
            return;
        }

        dict.get(name).printGrades();
    }
    static void addNewGrade(Map<String, Subject> dict) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the name of a subject: ");
        String name = stdin.nextLine().trim().toLowerCase();

        if(!dict.containsKey(name)) {
            System.out.println("No such subject has been added");
            return;
        }

        System.out.print("Enter the grade: ");
        int grade = stdin.nextInt();

        System.out.print("Enter the weight: ");
        int weight = stdin.nextInt();

        System.out.println("Do you wish to add additional description?\n1 for yes, 0 for no");
        int wantsDescription = stdin.nextInt();
        Grade g;
        if(wantsDescription == 1) {
            System.out.print("Enter the description: ");
            String description = stdin.next();
            g = new Grade(grade, weight, description);
        } else
            g = new Grade(grade, weight);


        dict.get(name).addGrade(g);
    }
    static void handleGradeModificationInDictionary(Map<String, Subject> dict) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the name of a subject: ");
        String name = stdin.next().trim().toLowerCase();

        if(!dict.containsKey(name)) {
            System.out.println("No such subject has been added");
            return;
        }

        dict.get(name).printGrades();
        System.out.println("Which grade would you like to modify? \nEnter the ID, counting from 0");
        int gradeID = stdin.nextInt();

        boolean flag = true;
        while(flag) {
            System.out.println("What would you like to modify?");
            System.out.println("1. Grade itself");
            System.out.println("2. Weight");
            System.out.println("3. Description");

            int modificationChoice = stdin.nextInt();
            switch (modificationChoice) {
                case 1 -> {
                    System.out.print("Enter the new grade: ");
                    dict.get(name).modifyGradesGrade(gradeID, stdin.nextInt() );
                    flag = false;
                }
                case 2 -> {
                    System.out.print("Enter the new weight: ");
                    dict.get(name).modifyGradesWeight(gradeID, stdin.nextInt() );
                    flag = false;
                }
                case 3 -> {
                    System.out.print("Enter the new description: ");
                    dict.get(name).modifyGradesDescription(gradeID, stdin.next().trim() );
                    flag = false;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }
    public static void main(String[] args) {
//        Example code, for testing and demonstration purposes
//
//        Subject math = new Subject( "Math", "Theresa W" );
//
//        math.addGrade( new Grade(4, 1, "Aktywność") )
//                .addGrade( new Grade(6, 3, "Sprawdzian") )
//                .addGrade( new Grade(1, 1) );
//
//        math.modifyGradesGrade(0, 6)
//                .modifyGradesWeight(0, 2)
//                .modifyGradesDescription(2, "Kartkówka");
//
//        math.printGrades();
//        System.out.println(math.calculateAverage());
//
//        math.removeGrade(1);
//        math.printGrades();
//        System.out.println(math.calculateAverage());
        final Map<String, Subject> subjects = new HashMap<>();
        Scanner stdin = new Scanner(System.in);
        int choice;

        while(true) {
            printMenu();
            choice = stdin.nextInt();
            stdin.nextLine();

            switch(choice) {
                case 0 -> System.exit(0);
                case 1 -> addNewSubjectToMap(subjects);
                case 2 -> printGradesFromSubjectFromDictionary(subjects);
                case 3 -> handleGradeModificationInDictionary(subjects);
                case 4 -> System.out.println(subjects);
                case 5 -> addNewGrade(subjects);
                case 6 -> {
                    System.out.print("Enter the subject's name: ");
                    String name = stdin.next().trim().toLowerCase();

                    if(!subjects.containsKey(name)){
                        System.out.println("The subject doesn't exist");
                        break;
                    }

                    subjects.remove(name);
                    System.out.println("Subject removed successfully");
                }
                case 7 -> {
                    System.out.print("Enter the subject's name: ");
                    String name = stdin.next().trim().toLowerCase();

                    if(!subjects.containsKey(name)){
                        System.out.println("The subject doesn't exist");
                        break;
                    }

                    System.out.printf("%s average = %f", name, subjects.get(name).calculateAverage());
                }
                default -> System.out.println("Invalid argument");
            }
        }

    }
}
