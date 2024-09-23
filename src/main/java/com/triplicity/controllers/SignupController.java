package com.triplicity.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    private FirebaseAuth auth;

    public SignupController() {
        auth = FirebaseAuth.getInstance();
    }

    @FXML
    public void handleSignup() {
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        // Create a new user in Firebase
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = auth.createUser(request);
            System.out.println("User signed up successfully: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            System.out.println("Signup failed: " + e.getMessage());
        }
    }
}
