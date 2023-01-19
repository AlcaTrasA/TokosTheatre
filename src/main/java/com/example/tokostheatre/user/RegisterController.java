package com.example.tokostheatre.user;

import Models.User;
import Models.UserType;
import SQL.Helper;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterController extends Controller {
    Startup startup = new Startup();

    @FXML
    private TextField usernameText;

    @FXML
    private TextField fullNameText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField repeatPasswordText;

    @FXML
    private Label wrongText;

    @FXML
    private Label correctText;

    public void print(){
        System.out.println("Switch");
    }

    public void onGoBackClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Go Back' - ");
        switchScene("login",536,400,event);
//        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Toko's Theatre");
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);

//        print();
    }
    public void onRegisterClick(ActionEvent event) throws SQLException, IOException, InterruptedException {
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
                User user = new User(usernameText.getText(),passwordText.getText(),fullNameText.getText(),emailText.getText(),0,UserType.USER);
                SqlConfiguration sqlConfiguration = new SqlConfiguration();
                sql.addUser(user);
                correctText.setText("Successfully Registered!");
            }
        }

        startup.write("* Clicked on 'REGISTER' - ");
    }
}
