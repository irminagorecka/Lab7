module com.example.lab7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.management;


    opens com.example.lab7 to javafx.fxml;
    exports com.example.lab7;
}