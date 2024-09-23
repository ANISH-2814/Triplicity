package com.triplicity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseService {

    private static FirebaseAuth auth;
    private static FirebaseDatabase database;

    // Initialize Firebase
    public static void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("/media/anishbawdhankar/Study/Study/new project /Triplicity/src/main/resources/triplicity-85671-firebase-adminsdk-38q8k-0040d16eb9.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://triplicity-85671-default-rtdb.firebaseio.com/") // Replace with your Database URL
                .build();

        FirebaseApp.initializeApp(options);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    // Login function
    public static UserRecord loginUser(String email) throws Exception {
        return auth.getUserByEmail(email);
    }

    // Signup function
    public static UserRecord signupUser(String email, String password) throws Exception {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        return auth.createUser(request);
    }

    // Store user data in Firebase Realtime Database
    public static void storeUserData(String userId, String email) {
        DatabaseReference ref = database.getReference("users").child(userId);
        ref.setValueAsync(new UserData(userId, email));
    }

    // Data class for storing user details
    public static class UserData {
        public String userId;
        public String email;

        public UserData(String userId, String email) {
            this.userId = userId;
            this.email = email;
        }
    }
}
