package Models;

import database.DatabaseHandler;

import java.sql.SQLException;

public class Alert {

    public void createAlert(String name, String text) throws SQLException {
        DatabaseHandler data = new DatabaseHandler();
        data.addNewAlert(name,text);
    }

}
