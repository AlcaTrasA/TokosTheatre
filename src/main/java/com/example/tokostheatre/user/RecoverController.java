package com.example.tokostheatre.user;

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
import java.sql.SQLException;
import java.util.Objects;

public class RecoverController extends Controller {
    Startup startup = new Startup();

    boolean approval = false;

    @FXML
    private Label wrongText;

    @FXML
    private Label correctText;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private Label wrongCheck;

    @FXML
    private Label correctCheck;

    @FXML
    private TextField password;

    @FXML
    private TextField repeatPassword;


    public void onCheckClick() throws SQLException {
        startup.write("* Clicked on 'Check' - ");
        wrongCheck.setText("");
        correctCheck.setText("");
        Helper helper = new Helper();
        if(helper.recover(username.getText(),email.getText())){
            startup.write("* Recovering as " + username.getText() + " " + email.getText());
            correctCheck.setText("Approved!");
            approval = true;
//            FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("resetpassword.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 735, 689);
//            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            stage.setTitle("Reset Password");
//            stage.setScene(scene);
//            stage.show();
//            stage.setResizable(false);
        }
        else if(!helper.signin(username.getText(), email.getText())){
            wrongCheck.setText("Declined!");
            approval = false;
        }
    }

    public void onRecoverClick(ActionEvent event) throws SQLException, IOException {
        startup.write("* Clicked on 'Recover' - ");
        wrongText.setText("");
        SqlConfiguration sql = new SqlConfiguration();
        Helper helper = new Helper();
        if(!approval){
            wrongText.setText("Please verify username and email first!");
        }
        else if(!Objects.equals(password.getText(), repeatPassword.getText())){
            wrongText.setText("Password don't match!");
            System.out.println(password.getText() + " " + repeatPassword.getText());
        }else if(Objects.equals(password.getText(), repeatPassword.getText())){
            correctText.setText("Successfully changed password");
            System.out.println("t");
            sql.setPasswordByUsername(password.getText(),username.getText());
            String oldPassword = sql.getPasswordByUsername(username.getText());
            startup.write("* Changed Password for: " + username + " from: " + oldPassword + " to: " + password.getText());
        }

    }
    public void onGoBackClick(ActionEvent event) throws IOException {
        startup.write("* Clicked On 'Go Back' - ");
        switchScene("login",536,400,event);
//        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Toko's Theatre");
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);
    }
}
