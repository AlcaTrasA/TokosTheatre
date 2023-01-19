package com.example.tokostheatre.admin;

import Models.Movie;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AddMovieController extends Controller {
    Startup startup = new Startup();

    File file;

    Image img = null;

    @FXML
    private TextArea details;

    @FXML
    private TextField director;

    @FXML
    private Label correctText;

    @FXML
    private Label wrongText;

    @FXML
    private TextField id;

    @FXML
    private TextField imdb;

    @FXML
    private TextField name;

    @FXML
    private ImageView poster;

    @FXML
    private TextField cost;

    private String user;

    @FXML
    private void getposter(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG =
                new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg =
                new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG =
                new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        try
        {
            file = fileChooser.showOpenDialog(((Stage) id.getScene().getWindow()));
            Image image = new Image(file.toURI().toString());
            System.out.println(image.getUrl());
            img = image;
            poster.setImage(image);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onSubmitClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        correctText.setText("");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(Objects.equals(name.getText(), "")||Objects.equals(director.getText(), "")||Objects.equals(details.getText(), "")||Objects.equals(imdb.getText(), "")||Objects.equals(cost.getText(), "")){
            wrongText.setText("Some Of The field Is Empty!");
        }
        else if(sqlConfiguration.checkMovie(Integer.parseInt(id.getText()))){
            wrongText.setText("Movie On That Id already registered!");
        }
        else{
            Movie movie = new Movie(Integer.parseInt(id.getText()),name.getText(),director.getText(),details.getText(),Double.parseDouble(imdb.getText()),img,Double.parseDouble(cost.getText()),"");
            sqlConfiguration.addMovie(movie);
            correctText.setText("Movie Successfully added!");
        }
    }

    @FXML
    public void onGoBackClick(ActionEvent event) throws IOException {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

    public void setName(String name) {
        user=name;
    }
}
