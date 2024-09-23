package com.triplicity;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import com.google.firebase.auth.UserRecord;

public class LoginView extends VBox {

    public LoginView(BorderPane root) {
        Label titleLabel = new Label("Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String email = usernameField.getText();
            // Password is not used here because we're not verifying it in the Admin SDK
            try {
                UserRecord user = FirebaseService.loginUser(email);
                if (user != null) {
                    showAlert(Alert.AlertType.INFORMATION, "Login Success", "Logged in successfully as " + user.getEmail());
                } else {
                    showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "An error occurred during login");
            }
        });

        Button signupButton = new Button("Go to Signup");
        signupButton.setOnAction(e -> {
            SignupView signupView = new SignupView(root);
            root.setCenter(signupView);
        });

        getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, signupButton);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
