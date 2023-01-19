package database;

import Models.User;
import Models.UserType;
import SQL.SqlConfiguration;
import SQL.Startup;

import javax.xml.transform.Result;
import java.sql.*;


public class DatabaseHandler {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/tokostheatre";

    public static Connection connect(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could Not Connect to Server!");
            e.getCause();
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();
        }
        return connection;
    }

    public int getAlertId() throws SQLException {
        int id = 0;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM tokostheatre.alert;");
        while(rs.next()){
            id = rs.getInt(1);
        }
        return id;
    }
    public String getAlertName() throws SQLException {
        String name = "";
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM tokostheatre.alert WHERE id=" + getAlertId() + ";");
        while(rs.next()){
            name = rs.getString(1);
        }
        return name;
    }
    public String getAlertText() throws SQLException {
        String text = "";
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT text FROM tokostheatre.alert WHERE id=" + getAlertId() + ";");
        while(rs.next()){
            text = rs.getString(1);
        }
        return text;
    }
    public void addNewAlert(String name, String text) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO tokostheatre.alert values(?,?,?)");
        stmt.setInt(1,getAlertId()+1);
        stmt.setString(2,name);
        stmt.setString(3,text);
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Added new Alert: " + "Name: " + name + ",  Text: " + text);
        System.out.println(name);
        System.out.println(text);
    }
    public UserType authUser(final String username, final String password) throws SQLException {
        Connection con = connect();
        UserType type = null;
        PreparedStatement st = null;
        st = connect().prepareStatement("select type from tokostheatre.users where username=? and password=?;");
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            type = UserType.valueOf(rs.getString(1));
        }
        return type;
    }
    public void clearUsers() throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM tokostheatre.users WHERE type='USER';");
        stmt.executeUpdate();
    }
    public void truncateTableUsers() throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE tokostheatre.users;");
        stmt.executeUpdate();
        Startup startup = new Startup();
        startup.write("# TRUNCATED TABLE 'tokostheatre.users' - ");
    }

    public void start() throws SQLException {
        Connection con = connect();
        PreparedStatement schema = con.prepareStatement("CREATE SCHEMA `tokostheatre` ;");
        PreparedStatement users = con.prepareStatement("CREATE table users(id INT(11) PRIMARY KEY NOT NULL, username VARCHAR(45), password VARCHAR(45), fullname VARCHAR(45), email VARCHAR(45), money DOUBLE, time VARCHAR(45), type ENUM('ADMIN', 'USER'));");
        PreparedStatement alert = con.prepareStatement("CREATE table alert(id INT(11) PRIMARY KEY NOT NULL, name VARCHAR(45), text VARCHAR(45));");
        PreparedStatement movies = con.prepareStatement("CREATE table movies(id INT(11) PRIMARY KEY NOT NULL, name VARCHAR(45), director VARCHAR(45), details VARCHAR(999), imdb DOUBLE, address VARCHAR(99), price DOUBLE, bought VARCHAR(99);");
        PreparedStatement tickets = con.prepareStatement("CREATE TABLE `tokostheatre`.`ticket` (\n" +
                "  `userid` INT NULL,\n" +
                "  `movieid` INT(11),\n" +
                "  `time` VARCHAR(45) NULL);");
        schema.executeUpdate();
        users.executeUpdate();
        alert.executeUpdate();
        movies.executeUpdate();
        tickets.executeUpdate();
    }
}
