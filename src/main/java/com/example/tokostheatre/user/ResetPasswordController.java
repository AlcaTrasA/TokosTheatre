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

public class ResetPasswordController extends Controller {
    Startup startup = new Startup();

    @FXML
    private Label wrongText;

    @FXML
    private TextField password;

    @FXML
    private TextField repeatPassword;

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
    }

    public void onResetClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Reset' - ");
        wrongText.setText("");
        Helper helper = new Helper();
        if(helper.reset(password.getText(),repeatPassword.getText())){
            startup.write("* Resetting as " + password.getText());
            wrongText.setText("TRUEEE");
            startup.write("* Reset Password! - ");
            switchScene("login",536,400,event);
//            FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            stage.setTitle("Toko's Theatre");
//            stage.setScene(scene);
//            stage.show();
//            stage.setResizable(false);
        }
        else{
            wrongText.setText("Passwords don't match!");
        }
    }
}
