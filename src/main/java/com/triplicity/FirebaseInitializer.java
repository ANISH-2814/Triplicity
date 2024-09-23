package com.triplicity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {

    public static void initialize() {
        try {
            // Path to the serviceAccountKey.json file
            FileInputStream serviceAccount = new FileInputStream("/media/anishbawdhankar/Study/Study/new project /Triplicity/src/main/resources/triplicity-85671-firebase-adminsdk-38q8k-0040d16eb9.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Initialize the Firebase app
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase Initialized Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
