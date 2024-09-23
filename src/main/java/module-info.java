module com.triplicity {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.api.apicommon;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires com.google.auth; // Google Auth Library



    opens com.triplicity to javafx.fxml;
    exports com.triplicity;
}