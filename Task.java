/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String taskStatus; // Add task status attribute

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, double taskDuration) {
        // Initialize other attributes...
        this.taskStatus = "To Do"; // Set default task status to "To Do"
    }

    // Getter methods for attributes
    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    // Setter method for task status
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
  public String getTaskID() {
        // Generate task ID based on the specified format
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskId;
    }
}

