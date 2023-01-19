package com.example.tokostheatre.admin;

import SQL.Startup;
import com.example.tokostheatre.Controller;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ClearUsersController extends Controller {

    Startup startup = new Startup();
    private String user;

    @FXML
    void onDeleteUsersClick(ActionEvent event) {
        startup.write("# Cleared Users from TABLE 'tokostheatre.users' - ");
        DatabaseHandler data = new DatabaseHandler();
        try {
            data.clearUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switchScene("adminhome",642,496,event);
    }

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
        System.out.println(username.getText());
    }
    public void setName(String name) {
        user=name;
    }
}
