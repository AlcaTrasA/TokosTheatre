package com.example.tokostheatre.admin;

import Models.UserType;
import SQL.Helper;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Objects;

public class EditUserController extends Controller {
    Startup startup = new Startup();

    boolean approval = false;
    @FXML
    private TextField changeMoney;

    @FXML
    private TextField changeEmail;

    @FXML
    private TextField changeFullName;

    @FXML
    private TextField changePassword;

    @FXML
    private TextField changeUsername;

    @FXML
    private Label correctConnect;

    @FXML
    private Label correctText;

    @FXML
    private TextField searchUsername;

    @FXML
    private Label wrongConnect;

    @FXML
    private Label wrongText;

    private String user;

    @FXML
    void onChangeCredentialsClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        correctText.setText("");
        if(!approval){
            wrongText.setText("Please Find User First!");
        }else{
            SqlConfiguration sql = new SqlConfiguration();
            if(!Objects.equals(changeUsername.getText(), "")){
                sql.changeUsernameByUsername(searchUsername.getText(),changeUsername.getText());
                searchUsername.setText(changeUsername.getText());
                System.out.println("a");
            }
            if(!Objects.equals(changePassword.getText(), "")){
                sql.changePasswordByUsername(searchUsername.getText(),changePassword.getText());
                System.out.println("b");
            }
            if(!Objects.equals(changeFullName.getText(), "")){
                sql.changeFullNameByPassword(searchUsername.getText(),changeFullName.getText());
                System.out.println("c");
            }
            if(!Objects.equals(changeEmail.getText(), "")){
                sql.changeEmailByUsername(searchUsername.getText(),changeEmail.getText());
                System.out.println("d");
            }
            if(!Objects.equals(changeMoney.getText(), "")){
                sql.changeMoneyByUsername(searchUsername.getText(),Double.parseDouble(changeMoney.getText()));
//                System.out.println(Double.parseDouble(changeMoney.getText()));
                System.out.println("e");
            }
            correctText.setText("Changes Applied");
        }
    }

    @FXML
    void onFindUserClick(ActionEvent event) throws SQLException {
        startup.write("# Clicked on 'Find User' - ");
        correctConnect.setText("");
        Helper helper = new Helper();
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        boolean userExistence = sqlConfiguration.checkUser(searchUsername.getText());
        if(userExistence) {
            wrongConnect.setText("");
            correctConnect.setText("User Found!");
            System.out.println("arsebobs");
            approval = true;
        }
        else {
            correctConnect.setText("");
            wrongConnect.setText("User Not Connected");
            System.out.println("AR ARSEBOBS");
            approval = false;
        }
        System.out.println(approval);
    }

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }


    public void setName(String name) {
        user=name;
    }
}
