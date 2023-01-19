package com.example.tokostheatre.user;

import Models.Movie;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import com.example.tokostheatre.TokosTheatreApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserMoviesController extends Controller {
    Startup startup = new Startup();

    @FXML
    private Label balance;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    private String user;

    public void setName(String name) throws SQLException {
        user = name;
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        balance.setText(String.valueOf(sqlConfiguration.getBalanceByUsername(user)));
        image1.setImage(sqlConfiguration.getMovieById(1).getImage());
        image2.setImage(sqlConfiguration.getMovieById(2).getImage());
        image3.setImage(sqlConfiguration.getMovieById(3).getImage());
        image4.setImage(sqlConfiguration.getMovieById(4).getImage());
    }

    @FXML
    void onHomeClick(ActionEvent event) throws SQLException {
        System.out.println(user);
        TextField username = new TextField();
        username.setText(user);
        userScene(username,event);
    }

    @FXML
    void onMoviesClick(ActionEvent event) {

    }

    @FXML
    void onProfileClick(ActionEvent event) {

    }

    @FXML
    void onImage1Click(ActionEvent event) throws SQLException {
        System.out.println("1");
        startup.write("# Clicked On 'Movie' - ");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(sqlConfiguration.checkMovie(1)){
            Movie mv = new SqlConfiguration().getMovieById(1);
            String page = "movie";
            int v = 567;
            int v1 = 497;
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
            MovieController movieController = fxmlLoader.getController();
            movieController.setName(user, mv);
        }


    }

    @FXML
    void onImage2Click(ActionEvent event) throws SQLException {
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(sqlConfiguration.checkMovie(2)){
            System.out.println("2");
            startup.write("# Clicked On 'Movie' - ");
            Movie mv = new SqlConfiguration().getMovieById(2);
            String page = "movie";
            int v = 567;
            int v1 = 497;
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
            MovieController movieController = fxmlLoader.getController();
            movieController.setName(user, mv);
        }
    }

    @FXML
    void onImage3Click(ActionEvent event) throws SQLException {
        System.out.println("3");
        startup.write("# Clicked On 'Movie' - ");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(sqlConfiguration.checkMovie(3)){
            Movie mv = new SqlConfiguration().getMovieById(3);
            String page = "movie";
            int v = 567;
            int v1 = 497;
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
            MovieController movieController = fxmlLoader.getController();
            movieController.setName(user, mv);
        }
    }

    @FXML
    void onImage4Click(ActionEvent event) throws SQLException {
        System.out.println("4");
        startup.write("# Clicked On 'Movie' - ");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(sqlConfiguration.checkMovie(4)){
            Movie mv = new SqlConfiguration().getMovieById(4);
            String page = "movie";
            int v = 567;
            int v1 = 497;
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
            MovieController movieController = fxmlLoader.getController();
            movieController.setName(user, mv);
        }
    }

}
