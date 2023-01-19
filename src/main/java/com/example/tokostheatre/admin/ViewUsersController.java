package com.example.tokostheatre.admin;

import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.SQLException;

public class ViewUsersController extends Controller {
    Startup startup = new Startup();

    private String user;

    public void setName(String name) {
        user=name;
    }

    @FXML
    private TextField email;

    @FXML
    private TextField fullname;

    @FXML
    private TextArea lastLogin;

    @FXML
    private TextField money;

    @FXML
    private TextField password;

    @FXML
    private TextField type;

    @FXML
    private TextField username;

    @FXML
    private Label wrongText;

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

    @FXML
    void onCheckClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(!sqlConfiguration.checkUsername(username.getText())){
            wrongText.setText("Username Not Found!");
        }else{
            password.setText(sqlConfiguration.getPasswordByUsername(username.getText()));
            fullname.setText(sqlConfiguration.getFullnameByUsername(username.getText()));
            email.setText(sqlConfiguration.getEmailByUsername(username.getText()));
            money.setText(sqlConfiguration.getMoneyByUsername(username.getText()));
            type.setText(sqlConfiguration.getTypeByUsername(username.getText()));
            lastLogin.setText(sqlConfiguration.getTimeByUsername(username.getText()));
        }
    }

}
