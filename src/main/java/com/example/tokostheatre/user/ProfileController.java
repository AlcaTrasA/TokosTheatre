package com.example.tokostheatre.user;

import Models.Movie;
import Models.TableUser;
import SQL.SqlConfiguration;
import com.example.tokostheatre.Controller;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController extends Controller {

    @FXML
    private Label username;

    private String user;

    public void setName(String name) throws SQLException {
        user = name;
        username.setText(user);


    }

    @FXML
    void onGoBackClick(ActionEvent event) throws SQLException {
        TextField textField = new TextField();
        textField.setText(user);
        userScene(textField,event);
    }

    //au aq vegar movaswari dawera tore vapirebdi bought ticketebs
}
