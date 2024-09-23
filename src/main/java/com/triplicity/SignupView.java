package com.triplicity;

import com.google.firebase.auth.UserRecord;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class SignupView extends VBox {

    public SignupView(BorderPane root) {
        Label titleLabel = new Label("Signup");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signupButton = new Button("Signup");
        signupButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            try {
                // Signup user with Firebase
                UserRecord userRecord = FirebaseService.signupUser(email, password);
                FirebaseService.storeUserData(userRecord.getUid(), email);

                showAlert(Alert.AlertType.INFORMATION, "Signup Success", "Account created for: " + userRecord.getEmail());
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Signup Failed", "An error occurred during signup");
            }
        });

        Button loginButton = new Button("Go to Login");
        loginButton.setOnAction(e -> {
            LoginView loginView = new LoginView(root);
            root.setCenter(loginView);
        });

        getChildren().addAll(titleLabel, emailField, passwordField, signupButton, loginButton);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
