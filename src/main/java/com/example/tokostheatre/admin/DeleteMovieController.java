package com.example.tokostheatre.admin;

import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteMovieController extends Controller {
    Startup startup = new Startup();

    @FXML
    private Label correctText;

    @FXML
    private TextField id;

    @FXML
    private Label wrongText;

    private String user;

    public void setName(String name) {
        user = name;
    }

    @FXML
    void onDeleteUserClick(ActionEvent event) throws SQLException {
        wrongText.setText("");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        if(!sqlConfiguration.checkMovie(Integer.parseInt(id.getText()))){
            wrongText.setText("Username Not Found!");
        }else{
            sqlConfiguration.deleteMovie(Integer.parseInt(id.getText()));
            correctText.setText(id.getText() + " Deleted!");
        }
    }

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

}
