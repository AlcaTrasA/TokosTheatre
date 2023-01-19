package com.example.tokostheatre.admin;

import SQL.Startup;
import com.example.tokostheatre.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomeController extends Controller {

    public AdminHomeController() {

    }

    Startup startup = new Startup();

    @FXML
    public Label welcomeText;

    private String user = "";

    public void setName(String name){
        welcomeText.setText("Welcome " + name);
        user=name;
    }

    public void onViewUsersClick(ActionEvent event) {
        startup.write("# Clicked On 'View Users' - ");

        String page = "viewusers";
        int v = 419;
        int v1 = 598;
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
        ViewUsersController viewUsersController = fxmlLoader.getController();
        viewUsersController.setName(user);
    }

    public void onLogoutClick(ActionEvent event) throws IOException {
//        startup.write();
//        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Toko's Theatre");
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);
        switchScene("login",536,400,event);
    }

    public void onViewAdminsClick(ActionEvent event) {
    }

    public void onAddNewAdminClick(ActionEvent event) {
        startup.write("# Clicked On 'Add new Admin' - ");
//        switchScene("adminregisteruser",459,616,event);

        String page = "adminregisteradmin";
        int v = 459;
        int v1 = 616;
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
        AdminRegisterAdminController adminRegisterAdminController = fxmlLoader.getController();
        adminRegisterAdminController.setName(user);
//        adminScene(user,event);
    }

    public void onAddNewAlertClick(ActionEvent event) throws IOException {
        startup.write("# Clicked On 'Add New Alert' - ");

        String page = "addalert";
        int v = 470;
        int v1 = 400;
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
        AddAlertController addAlertController = fxmlLoader.getController();
        addAlertController.setName(user);
    }

    public void onAddNewMovieClick(ActionEvent event){
        startup.write("# Clicked On 'Add New Movie' - ");

        String page = "addmovie";
        int v = 735;
        int v1 = 689;
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
        AddMovieController addMovieController = fxmlLoader.getController();
        addMovieController.setName(user);
    }

    public void onDeleteMovieClick(ActionEvent event){
        startup.write("# Clicked On 'Delete Movie' - ");

        String page = "deletemovie";
        int v = 419;
        int v1 = 327;
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
        DeleteMovieController deleteMovieController = fxmlLoader.getController();
        deleteMovieController.setName(user);
    }

    public void onEditMovieClick(ActionEvent event){
        String page = "editmovie";
        int v = 860;
        int v1 = 623;
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
        EditMovieController editMovieController = fxmlLoader.getController();
        editMovieController.setName(user);
    }

    public void onTruncateClick(ActionEvent event){
        startup.write("# Clicked On 'Truncate' - ");

        String page = "truncate";
        int v = 417;
        int v1 = 400;
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
        TruncateController truncateController = fxmlLoader.getController();
        truncateController.setName(user);
    }

    public void onDeleteUserClick(ActionEvent event){
        startup.write("# Clicked On 'Delete User' - ");

        String page = "deleteuser";
        int v = 419;
        int v1 = 327;
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
        DeleteUserController deleteUserController = fxmlLoader.getController();
        deleteUserController.setName(user);
    }

    public void onAddNewUserClick(ActionEvent event) {
        startup.write("# Clicked On 'Add new User' - ");
//        switchScene("adminregisteruser",459,616,event);

        String page = "adminregisteruser";
        int v = 459;
        int v1 = 616;
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
        AdminRegisterUserController adminRegisterUserController = fxmlLoader.getController();
        adminRegisterUserController.setName(user);
//        adminScene(user,event);

    }

    public void onEditUserClick(ActionEvent event) {
        startup.write("# Clicked On 'Edit User' - ");
//        switchScene("adminregisteruser",459,616,event);

        String page = "edituser";
        int v = 509;
        int v1 = 577;
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
        EditUserController editUserController = fxmlLoader.getController();
        editUserController.setName(user);
//        adminScene(user,event);
    }

//    public void onLogsClick(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(TokosTheatreApplication.class.getResource("logs.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 536, 400);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Toko's Theatre");
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);
//    }
    public void onClearUsersClick(ActionEvent event){
        startup.write("# Clicked On 'Clear Users' - ");
//        switchScene("adminregisteruser",459,616,event);

        String page = "clearusers";
        int v = 417;
        int v1 = 400;
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
        ClearUsersController clearUsersController = fxmlLoader.getController();
        clearUsersController.setName(user);
    }

    public void onEditYourProfileClick(ActionEvent event) {
    }
}
