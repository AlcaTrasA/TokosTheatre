package com.example.tokostheatre.admin;

import Models.User;
import Models.UserType;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminRegisterAdminController extends Controller {
    Startup startup = new Startup();

    @FXML
    private Label correctText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField fullNameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField repeatPasswordText;

    @FXML
    private TextField usernameText;

    @FXML
    private Label wrongText;

    private String user;

    public void setName(String name) {
        user=name;
    }

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

    @FXML
    void onRegisterClick(ActionEvent event) throws SQLException, IOException {
        wrongText.setText("");
        correctText.setText("");
        SqlConfiguration sql = new SqlConfiguration();
        if (sql.checkUsername(usernameText.getText())){
            wrongText.setText("Username Already Registered!");
        }
        else if (sql.checkEmail(emailText.getText())){
            wrongText.setText("Email Already Registered!");
        }else{
            if(usernameText.getText()==""||passwordText.getText()==""||fullNameText.getText()==""||emailText.getText()==""){
                wrongText.setText("Some of the credentials are empty!");
            }
            else if(!Objects.equals(passwordText.getText(), repeatPasswordText.getText())){
                wrongText.setText("Passwords don't match!");
                System.out.println(passwordText.getText());
                System.out.println(repeatPasswordText.getText());
            }
            else {
                java.util.Date date = new java.util.Date();
                User user = new User(usernameText.getText(),passwordText.getText(),fullNameText.getText(),emailText.getText(),-1, UserType.USER);
                SqlConfiguration sqlConfiguration = new SqlConfiguration();
                sql.addAdmin(user);
                correctText.setText("Successfully Registered!");
            }
        }

        startup.write("* Clicked on 'REGISTER' - ");
    }

}
