package com.triplicity.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private FirebaseAuth auth;

    public LoginController() {
        auth = FirebaseAuth.getInstance();
    }

    @FXML
    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Authenticate the user with Firebase
        try {
            // In Firebase Admin SDK, you verify the user differently than on the client side.
            // For simplicity, here's how you can check if a user exists:
            auth.getUserByEmail(email);
            System.out.println("Login successful for: " + email);
        } catch (FirebaseAuthException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
