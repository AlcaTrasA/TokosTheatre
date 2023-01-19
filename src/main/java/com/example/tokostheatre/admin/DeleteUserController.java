package com.example.tokostheatre.admin;

import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteUserController extends Controller {
    Startup startup = new Startup();

    private String user;

    @FXML
    private Label correctText;

    @FXML
    private TextField username;

    @FXML
    private Label wrongText;

    public void setName(String name) {
        user=name;
    }

    @FXML
    void onDeleteUserClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        correctText.setText("");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(!sqlConfiguration.checkUser(username.getText())){
            wrongText.setText("Username Not Found!");
        }else{
            sqlConfiguration.deleteUser(username.getText());
            correctText.setText(username.getText() + " Deleted!");
        }
    }


    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

}
