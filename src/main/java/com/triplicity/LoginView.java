package com.triplicity;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
    public LoginView(BorderPane root) {
        Label titleLabel = new Label("Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            // Simulate login
            System.out.println("Logging in with: " + usernameField.getText());
        });

        Button signupButton = new Button("Go to Signup");
        signupButton.setOnAction(e -> {
            SignupView signupView = new SignupView(root);
            root.setCenter(signupView);
        });

        getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, signupButton);
    }
}
