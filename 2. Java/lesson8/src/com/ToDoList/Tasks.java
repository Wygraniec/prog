package com.ToDoList;

import java.util.LinkedList;
import java.util.List;

public class Tasks {
    private List<Task> tasks;

    public Tasks() { this.tasks = new LinkedList<>(); }

    /**
     * Clears the list of tasks
     * */
    public void clear(){ tasks = new LinkedList<>(); }

    /**
     * Adds new task to the list
     * @param task Grade to be added
     * */
    public void add(Task task){ tasks.add(task); }

    /** Prints the list of tasks */
    public void print(){ print(false); }
    /**
     * Prints the list of tasks
     * @param showIDs Determines whether to show ids of tasks in the list
     * */
    public void print(Boolean showIDs) {
        int id = 0;
        System.out.println();
        for(Task task : tasks) {
            if(showIDs)
                System.out.printf("%d. ", id);

            System.out.printf("%s\nOpis: %s\n",
                    task.getName(),
                    task.getDescription());

            id++;
        }
        System.out.println();
    }

    /**
     * Removes a task from the list
     * @param id Index of grade to be removed
     * */
    public void remove(int id) { tasks.remove(id); }
}
