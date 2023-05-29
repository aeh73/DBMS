package com.example.betspetsvetgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button searchButton;

    @FXML
    private TextField idField;

    @FXML
    private TextField FirstNameField;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField DateField;

    @FXML
    private ListView listView;

    @FXML
    protected void handleSearch() {
        Connection con = HelloApplication.getConnection();

        String query = "SELECT * FROM tblAppointments WHERE staffID = ? AND staffFName = ? AND staffLName = ? AND date = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, idField.getText());
            pstmt.setString(2, FirstNameField.getText());
            pstmt.setString(3, LastNameField.getText());
            pstmt.setDate(4, java.sql.Date.valueOf(DateField.getText()));
            ResultSet rs = pstmt.executeQuery();

            // clear ListView before adding new results
            listView.getItems().clear();

            while (rs.next()) {
                // concatenating results into one string and adding it to the ListView
                listView.getItems().add(rs.getString("staffID") + " " +
                        rs.getString("staffFName") + " " +
                        rs.getString("staffLName") + " " +
                        rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}