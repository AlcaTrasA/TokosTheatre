package com.example.tokostheatre;

import SQL.SqlConfiguration;
import SQL.Startup;
import database.DatabaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

//first time run
public class TokosTheatreApplication extends Application {//register - 465 616 , login 536 400
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
        stage.setTitle("Toko's Theatre!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void checkStartup() throws IOException {
        Startup startup = new Startup();
        if(!startup.checkExistsStartup()){
            startup.createStartup();
            System.out.println("Startup Not Found!");
            System.out.println("Creating Startup (logger)!");
            DatabaseHandler databaseHandler = new DatabaseHandler();
            try {
                databaseHandler.start();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else System.out.println("Startup Already Exists");
    }
    public static void main(String[] args) {

        try {
            checkStartup();
        } catch (IOException e) {
            e.printStackTrace();
        }

        launch();

        //
    }
}