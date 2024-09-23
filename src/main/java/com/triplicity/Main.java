package com.triplicity;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Signup & Login Example");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 300);

        // Initialize Firebase
        try {
            FirebaseService.initializeFirebase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Show the login view by default
        LoginView loginView = new LoginView(root);
        root.setCenter(loginView);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
