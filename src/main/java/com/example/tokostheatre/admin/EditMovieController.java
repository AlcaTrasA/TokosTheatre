package com.example.tokostheatre.admin;

import Models.Movie;
import SQL.Helper;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.SQLException;
import java.util.Objects;

public class EditMovieController extends Controller {
    Startup startup = new Startup();

    boolean approval = false;
    File file;

    Image img = null;

    @FXML
    private Label correctConnect;

    @FXML
    private Label correctText;

    @FXML
    private TextArea details;

    @FXML
    private TextField id;

    @FXML
    private TextField imdb;

    @FXML
    private TextField searchId;

    @FXML
    private ImageView poster;

    @FXML
    private TextField name;

    @FXML
    private TextField director;

    @FXML
    private TextField price;

    @FXML
    private Label wrongConnect;

    @FXML
    private Label wrongText;

    private String user;

    public void setName(String name) {
        user = name;
    }

    private Movie movie = new Movie();

    @FXML
    void onBrowseClick(ActionEvent event) {
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
        try {
            file = fileChooser.showOpenDialog(((Stage) id.getScene().getWindow()));
            Image image = new Image(file.toURI().toString());
            System.out.println(image.getUrl());
            img = image;
            poster.setImage(image);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void onChangeCredentialsClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        correctText.setText("");
        if (!approval) {
            wrongText.setText("Please Find Movie First!");
        } else {
            SqlConfiguration sql = new SqlConfiguration();
            if (!Objects.equals(id.getText(), "")) {
                if (sql.checkMovie(Integer.parseInt(id.getText()))) {
                    wrongText.setText("Id already Used!");
                } else {
                    sql.changeIdById(Integer.parseInt(searchId.getText()), Integer.parseInt(id.getText()));
                    searchId.setText(String.valueOf(id.getText()));
                    System.out.println("a");
                }
            }
            if (!Objects.equals(name.getText(), "")) {
                sql.changeNameById(Integer.parseInt(searchId.getText()), name.getText());
                System.out.println("b");
            }
            if (!Objects.equals(director.getText(), "")) {
                sql.changeDirectorById(Integer.parseInt(searchId.getText()), director.getText());
                System.out.println("c");
            }
            if (!Objects.equals(price.getText(), "")) {
                sql.changePriceById(Integer.parseInt(searchId.getText()), Double.parseDouble(price.getText()));
                System.out.println("d");
            }
            if (!Objects.equals(imdb.getText(), "")) {
                sql.changeImdbById(Integer.parseInt(searchId.getText()), Double.parseDouble(imdb.getText()));
                System.out.println("e");
            }
            if (!Objects.equals(details.getText(), "")) {
                sql.changeDetailsById(Integer.parseInt(searchId.getText()), details.getText());
                System.out.println("f");
            }
            correctText.setText("Changes Applied");
        }
    }

    public void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username, event);
    }

    public void onFindMovieClick(ActionEvent event) throws SQLException {
        startup.write("# Clicked on 'Find Movie' - ");
        correctConnect.setText("");
        Helper helper = new Helper();
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        System.out.println(id.getText());
        boolean userExistence = sqlConfiguration.checkMovie(Integer.parseInt(searchId.getText()));
        if (userExistence) {
            wrongConnect.setText("");
            correctConnect.setText("Movie Found!");
            movie = sqlConfiguration.getMovieById(Integer.parseInt(searchId.getText()));
            System.out.println("arsebobs");
            System.out.println(movie.getName());
            System.out.println(movie.getId());

            approval = true;
        } else {
            correctConnect.setText("");
            wrongConnect.setText("Movie Not Connected");
            System.out.println("AR ARSEBOBS");
            approval = false;
        }
        System.out.println(approval);
    }
    @FXML
    void onClearTicketsClick(ActionEvent event) throws SQLException {
        correctText.setText("");
        wrongText.setText("");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        System.out.println("ID: " + Integer.parseInt(searchId.getText()));
        sqlConfiguration.clearTicketsById(Integer.parseInt(searchId.getText()));
        correctText.setText("Cleared Boughts!");
    }
}
