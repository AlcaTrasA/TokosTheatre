package com.example.tokostheatre.user;

import Models.Movie;
import SQL.SqlConfiguration;
import SQL.Startup;
import com.example.tokostheatre.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.w3c.dom.Text;

import java.sql.SQLException;

public class MovieController extends Controller {
    Startup startup = new Startup();

    private Double money;

    @FXML
    private Label correctText;

    @FXML
    private Label wrongText;

    @FXML
    private Label details;

    @FXML
    private Label director;

    @FXML
    private Label id;

    @FXML
    private Label imdb;

    @FXML
    private Label name;

    @FXML
    private Label cost;

    @FXML
    private ImageView poster;

    private String user;

    private Movie movie;

    public void setName(String nm, Movie mv) throws SQLException {
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        user=nm;
        movie=mv;
        money= Double.valueOf(sqlConfiguration.getMoneyByUsername(user));
        id.setText("id: " + String.valueOf(movie.getId()));
        name.setText(movie.getName());
        director.setText("Director: " + movie.getDirector());
        details.setText(movie.getDetails());
        imdb.setText(String.valueOf(movie.getImdb()) + "/10");
        cost.setText("Price: " + String.valueOf(movie.getPrice()));
        poster.setImage(mv.getImage());
        System.out.println(movie.getPrice() + " PRICE");
    }

    @FXML
    void onBuyClick(ActionEvent event) throws SQLException {
        correctText.setText("");
        wrongText.setText("");
        startup.write("* Clicked On 'Buy' - ");
        SqlConfiguration sqlConfiguration = new SqlConfiguration();
        System.out.println(sqlConfiguration.getIdByUser(user));
        System.out.println(movie.getId());
        if(sqlConfiguration.checkUserMovie(user, movie)){
            wrongText.setText("Already Bought!");
        }
        else if(money-movie.getPrice()<0){
            wrongText.setText("Not Enough Money!");
        }
        else {
            sqlConfiguration.buyTicket(movie.getId(), user);
            startup.write("$ Bought '" + movie.getName() + "' for '" + user + "' - ");
            correctText.setText("Successfully bought Ticket");
            SqlConfiguration sql = new SqlConfiguration();
            System.out.println(money);
            System.out.println(Double.parseDouble(sqlConfiguration.getMoneyByUsername(user)));
            double cash = money - movie.getPrice();
            System.out.println(cash);
            System.out.println(sql.getMoneyByUsername(user));
            sql.setMoneyById(sqlConfiguration.getIdByUser(user),cash);
            System.out.println(sql.getMoneyByUsername(user));
        }
    }

    @FXML
    void onGoBackClick(ActionEvent event) throws SQLException {
        startup.write("* Clicked on 'Go Back' - ");
        TextField textField = new TextField();
        textField.setText(user);
        userScene(textField,event);
    }

}
