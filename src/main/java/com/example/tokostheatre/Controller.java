package com.example.tokostheatre;

import SQL.Startup;
import com.example.tokostheatre.admin.AdminHomeController;
import com.example.tokostheatre.user.UserHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public abstract class Controller {
    public void switchScene(String page, int v, int v1, ActionEvent event) {
        Startup startup = new Startup();
        startup.write("* Switched Scene to '" + page + "' - ");
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
        stage.show();
        stage.setResizable(false);

    }

    public void adminScene(TextField username, ActionEvent event){
        String page = "adminhome";
        int v = 642;
        int v1 = 496;
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("adminhome.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 642, 496);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("adminhome");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        AdminHomeController adminHomeController = fxmlLoader.getController();
        adminHomeController.setName(username.getText());
    }

    public void userScene(TextField username, ActionEvent event) throws SQLException {
        String page = "userhome";
        int v = 642;
        int v1 = 496;
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("userhome.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 642, 496);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("userhome");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        UserHomeController userHomeController = fxmlLoader.getController();
        userHomeController.setName(username.getText());
    }

    public void movie1Scene(TextField username, ActionEvent event) throws SQLException {
        String page = "movie";
        int v = 642;
        int v1 = 496;
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("movie.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 642, 496);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("movie");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        UserHomeController userHomeController = fxmlLoader.getController();
        userHomeController.setName(username.getText());
    }

//    public void switchScene(String page, int v, int v1, String username, ActionEvent event){
//        Startup startup = new Startup();
//        startup.write("* Switched Scene to '" + page + "' - ");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(page + ".fxml"));
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        AdminHomeController adminHomeController = loader.getController();
//        adminHomeController.setName(username.getText());
//        signinButton.getScene().setRoot(root);
//    }
}
