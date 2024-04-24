/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */


public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor
    public Login() {
        this.username = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
    }

    // Method to check if username meets requirements
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if password meets requirements
    public boolean checkPasswordComplexity() {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecialChar;
    }

    // Method to register user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        // If both username and password meet requirements, register user
        return "User successfully registered.";
    }

    // Method to login user
    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Method to return login status
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + ". It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public static void main(String[] args) {
        Login newUser = new Login();

        // Registering user
        newUser.setUsername(JOptionPane.showInputDialog("Enter username:"));
        newUser.setPassword(JOptionPane.showInputDialog("Enter password:"));
        newUser.setFirstName(JOptionPane.showInputDialog("Enter first name:"));
        newUser.setLastName(JOptionPane.showInputDialog("Enter last name:"));

        JOptionPane.showMessageDialog(null, newUser.registerUser());

        // Logging in user
        String loginUsername = JOptionPane.showInputDialog("Enter username to login:");
        String loginPassword = JOptionPane.showInputDialog("Enter password to login:");

        boolean loginStatus = newUser.loginUser(loginUsername, loginPassword);

        JOptionPane.showMessageDialog(null, newUser.returnLoginStatus(loginStatus));
        JOptionPane.showMessageDialog(null, loginStatus);

            // Task management menu
            boolean loggedIn = true; // When user is already logged in
            TaskManager taskManager = new TaskManager();

            // Display task management menu
            while (loggedIn) {
                String optionString = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report (Coming Soon)\n3) Quit");
                int option = Integer.parseInt(optionString);

                switch (option) {
                    case 1:
                        taskManager.addTasks(); // Call TaskManager method to add tasks
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Show report feature is still in development. Coming Soon.");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting application...");
                        loggedIn = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
                }
            }
        
    }
}
