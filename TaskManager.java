/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManager {
    private ArrayList<Task> tasks;
    private static double totalHours = 0;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTasks() {
        String numOfTasksString = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
        int numOfTasks = Integer.parseInt(numOfTasksString);

        for (int i = 0; i < numOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");

            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (50 characters max):");
                if (taskDescription.length() > 50)
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            } while (taskDescription.length() > 50);

            String developerDetails = JOptionPane.showInputDialog("Enter developer details (First Name Last Name):");

            String taskDurationString = JOptionPane.showInputDialog("Enter task duration in hours:");
            double taskDuration = Double.parseDouble(taskDurationString);

            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration);
            tasks.add(task);

            totalHours += taskDuration;

            displayTaskDetails(task);
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    private void displayTaskDetails(Task task) {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task Status: ").append(task.getTaskStatus()).append("\n");
        taskDetails.append("Developer Details: ").append(task.getDeveloperDetails()).append("\n");
        taskDetails.append("Task Number: ").append(task.getTaskNumber()).append("\n");
        taskDetails.append("Task Name: ").append(task.getTaskName()).append("\n");
        taskDetails.append("Task Description: ").append(task.getTaskDescription()).append("\n");
        taskDetails.append("Task ID: ").append(task.getTaskID()).append("\n");
        taskDetails.append("Task Duration: ").append(task.getTaskDuration()).append(" hours\n");

        JOptionPane.showMessageDialog(null, taskDetails.toString());
    }
}
