package com.example.tokostheatre.admin;

import Models.Alert;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class AddAlertController extends Controller {
    Startup startup = new Startup();

    @FXML
    private Label wrongLabel;//

    @FXML
    private TextField name;

    @FXML
    private TextArea text;

    private String user;

    @FXML
    void onAddNewAlertClick(ActionEvent event) throws SQLException {
        Alert alert = new Alert();
        alert.createAlert(name.getText(),text.getText());

        //
//        DatabaseHandler data = new DatabaseHandler();
//        data.addNewAlert(name.getText(),text.getText());
    }
    @FXML
    void onGoBackClick(ActionEvent event) throws SQLException{
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }
    public void setName(String name) {
        user=name;
    }
}
