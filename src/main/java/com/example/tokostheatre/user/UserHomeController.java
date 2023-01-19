package com.example.tokostheatre.user;

import SQL.Startup;
import com.example.tokostheatre.Controller;
import com.example.tokostheatre.TokosTheatreApplication;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserHomeController extends Controller {

    public UserHomeController() throws SQLException {
//        alert.setText("");
//        DatabaseHandler data = new DatabaseHandler();
//
//        alert.setText(data.getAlertText());
    }

    Startup startup = new Startup();

    @FXML
    private Label alert;

    @FXML
    private Label welcomeText;

    private String user = "";

    public void setName(String name) throws SQLException {
        welcomeText.setText("Welcome " + name);
        user=name;

        DatabaseHandler data = new DatabaseHandler();
        welcomeText.setText("Welcome " + name + " to Toko's Theatre Application!");
        alert.setText(data.getAlertText() + " - " + data.getAlertName());
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Log Out' - ");
//        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Toko's Theatre");
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);
        switchScene("login",536,400,event);
    }

    @FXML
    void onMoviesClick(ActionEvent event) throws SQLException {
        System.out.println("ASD");
        startup.write("* Clicked on 'Movies' - ");
        String page = "usermovies";
        int v = 724;
        int v1 = 729;
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource(page + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), v, v1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("usermovies");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        UserMoviesController userMoviesController = fxmlLoader.getController();
        userMoviesController.setName(user);
    }

    @FXML
    void onProfileClick(ActionEvent event) throws SQLException {
        startup.write("* Clicked on 'Profile' - ");
        String page = "profile";
        int v = 409;
        int v1 = 403;
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource(page + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), v, v1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(page);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ProfileController profileController = fxmlLoader.getController();
        profileController.setName(user);
    }

//    public void setName(String name) throws SQLException {
//        DatabaseHandler data = new DatabaseHandler();
//        welcomeText.setText("Welcome " + name + " to Toko's Theatre Application!");
//        alert.setText(data.getAlertText() + " - " + data.getAlertName());
//    }
}
