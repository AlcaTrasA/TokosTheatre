package com.example.tokostheatre.admin;

import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class TruncateController extends Controller {
    Startup startup = new Startup();

    private String user;

    public void setName(String name) {
        user=name;
    }

    @FXML
    void onGoBackClick(ActionEvent event) {
        startup.write("* Clicked on 'Go Back' - ");
        TextField username = new TextField();
        username.setText(user);
        adminScene(username,event);
    }

    @FXML
    void onTruncateClick(ActionEvent event) throws SQLException {
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        sqlConfiguration.truncate();
        switchScene("login",536,400,event);
    }

}
