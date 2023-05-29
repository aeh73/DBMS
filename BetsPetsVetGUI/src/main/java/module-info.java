module com.example.betspetsvetgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.betspetsvetgui to javafx.fxml;
    exports com.example.betspetsvetgui;
}