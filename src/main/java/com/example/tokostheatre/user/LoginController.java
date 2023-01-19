package com.example.tokostheatre.user;

import Models.CurrentUser;
import Models.User;
import Models.UserType;
import SQL.Helper;
import SQL.SqlConfiguration;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class LoginController extends Controller {
    Startup startup = new Startup();
    static CurrentUser currentUser = new CurrentUser();

    @FXML
    private Label wrongText;

    @FXML
    private Label correctText;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button signinButton;

    public void print() {
        System.out.println("Switch");
    }

    public void onRegisterClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Register' - ");
        switchScene("register", 455, 616, event);
    }

    public void onSigninClick(ActionEvent event) throws SQLException, IOException {
        startup.write("* Clicked on 'Sign in' - ");
        wrongText.setText("");
        correctText.setText("");
        DatabaseHandler data = new DatabaseHandler();
        String file = getUserSceneByType(data.authUser(username.getText(), password.getText()));
        if(file==null){
            wrongText.setText("Invalid Credentials!");
        }
        else if(Objects.equals(file, "userhome")){
            userScene(username,event);
//            FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("userhome.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 642, 496);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setTitle("userhome");
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.show();
//            UserHomeController userHomeController = fxmlLoader.getController();
//            userHomeController.setName(username.getText());
        }
        else if(Objects.equals(file, "adminhome")){
            adminScene(username,event);
//            FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("adminhome.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 642, 496);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setTitle("adminhome");
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.show();
//            AdminHomeController adminHomeController = fxmlLoader.getController();
//            adminHomeController.setName(username.getText());
        }


//        else {
//            currentUser.setUsername(username.getText());
//            currentUser.setPassword(password.getText());
//            switchScene(file,642,496,event);
//        }
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminhome.fxml"));
//        Parent root = loader.load();
//        AdminHomeController adminHomeController = loader.getController();
//        adminHomeController.setName(username.getText());
//        signinButton.getScene().setRoot(root);
//        System.out.println(fileName);


        //var fileName = getUserSceneByType(data.authUser(username.getText(), password.getText()));
        //        fileName.ifPresentOrElse(
        //                (file) -> {
        //                    switchScene(file, 642, 496, event);
        //                }, () -> wrongText.setText("Invalid Credentials!"));
    }

    public void onRecoverClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Recover' - ");
        switchScene("recover", 486, 673, event);
    }

    private String getUserSceneByType(UserType type) {
        //private Optional<String>
//        return type == null ? Optional.empty() : Optional.of(switch (type) {
//            case USER -> "userhome";
//            case ADMIN -> "adminhome";
//        });
        return switch (type) {
            case USER -> "userhome";
            case ADMIN -> "adminhome";
            case null -> null;
        };
    }
}