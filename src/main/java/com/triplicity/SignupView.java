package com.triplicity;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SignupView extends VBox {
    public SignupView(BorderPane root) {
        Label titleLabel = new Label("Signup");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signupButton = new Button("Signup");
        signupButton.setOnAction(e -> {
            // Simulate signup
            System.out.println("Signing up with: " + usernameField.getText());
        });

        Button loginButton = new Button("Go to Login");
        loginButton.setOnAction(e -> {
            LoginView loginView = new LoginView(root);
            root.setCenter(loginView);
        });

        getChildren().addAll(titleLabel, usernameField, passwordField, signupButton, loginButton);
    }
}

