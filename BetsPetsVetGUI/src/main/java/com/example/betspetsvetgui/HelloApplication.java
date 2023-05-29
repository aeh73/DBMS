package com.example.betspetsvetgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Connection con;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
         connectDatabase(); launch();
    }
    private static void connectDatabase() {
        try {
            // Load Microsoft SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Define connection url
            String connectionUrl = "jdbc:sqlserver://localhost;instance=(localdb)\\local;databaseName=BetsPetsVet;integratedSecurity=true";

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl);

            // If connection is successful
            if (con != null) {
                System.out.println("Connected to the database!");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}