package SQL;

import Models.Movie;
import Models.User;
import database.DatabaseHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

import static Models.UserType.ADMIN;
import static Models.UserType.USER;

public class SqlConfiguration {
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

    public String getPasswordByUsername(String username) throws SQLException {
        String returnUsername = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT password FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnUsername = rs.getString(1);
        }
        return returnUsername;
    }

    public String getFullnameByUsername(String username) throws SQLException {
        String returnFullname = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT fullname FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnFullname = rs.getString(1);
        }
        return returnFullname;
    }


//    public void addUser(String username, String password, String fullname, String email, double money, Date time) throws SQLException, IOException {
//        Connection con = connect();
//        PreparedStatement stmt = con.prepareStatement("INSERT INTO tokostheatre.users values(?,?,?,?,?,?,?)");
//        stmt.setInt(1,getId());
//        stmt.setString(2,username);
//        stmt.setString(3,password);
//        stmt.setString(4,fullname);
//        stmt.setString(5,email);
//        stmt.setDouble(6, money);
//        stmt.setString(7, String.valueOf(time));
//        //
//        stmt.executeUpdate();
//        java.util.Date date = new java.util.Date();
//        Startup startup = new Startup();
//        startup.write("* Added User: " + getId() + ", " + username + ", " + fullname + ", " + email + ", " + money + ", " + time + " -");
//    }

    public void addUser(User user) throws SQLException, IOException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO tokostheatre.users values(?,?,?,?,?,?,?,?)");
        stmt.setInt(1,getId());
        stmt.setString(2,user.getUsername());
        stmt.setString(3,user.getPassword());
        stmt.setString(4,user.getFullname());
        stmt.setString(5,user.getEmail());
        stmt.setDouble(6, user.getMoney());
        stmt.setString(7, user.getTime());
        stmt.setString(8,String.valueOf(USER));
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("* Added User: " + user.getId() + ", " + user.getUsername() + ", " + user.getFullname() + ", " + user.getEmail()+ ", " + user.getMoney() + ", " + user.getTime() + " -");
    }

    public void addAdmin(User user) throws SQLException, IOException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO tokostheatre.users values(?,?,?,?,?,?,?,?)");
        stmt.setInt(1,getId());
        stmt.setString(2,user.getUsername());
        stmt.setString(3,user.getPassword());
        stmt.setString(4,user.getFullname());
        stmt.setString(5,user.getEmail());
        stmt.setDouble(6, user.getMoney());
        stmt.setString(7, user.getTime());
        stmt.setString(8,String.valueOf(ADMIN));
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("* Added Admin: " + user.getId() + ", " + user.getUsername() + ", " + user.getFullname() + ", " + user.getEmail()+ ", " + user.getMoney() + ", " + user.getTime() + " -");
    }

    public boolean checkUsername(String username) throws SQLException {
        boolean existsUsername = false;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select * from tokostheatre.users where username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(r1.next()) {
                existsUsername = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existsUsername;
    }
    public boolean checkEmail(String email) throws SQLException {
        boolean existsEmail = false;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select * from tokostheatre.users where email = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setString(1, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(r1.next()) {
                existsEmail = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existsEmail;
    }
    public int getMovieId() throws SQLException {
        int id = 0;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM tokostheatre.movies;");
        while(rs.next()){
            id = rs.getInt(1);
        }
        return id+1;
    }
    public int getId() throws SQLException {
        int id = 0;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM tokostheatre.users;");
        while(rs.next()){
            id = rs.getInt(1);
        }
        return id+1;
    }
    public String adminGetPasswordByUsername(String username) throws SQLException {
        String returnUsername = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT password FROM tokostheatre.admins WHERE username = '" + username + "';");
        while(rs.next()){
            returnUsername = rs.getString(1);
        }
        return returnUsername;
    }

    public void setPasswordByUsername(String newPassword,String username) throws SQLException {
        String password = null;
        Connection con = connect();
        String oldPassword = getPasswordByUsername(username);
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET password = '" + newPassword + "' WHERE username = '" + username + "';");
        stmt.executeUpdate();
        Startup startup = new Startup();
        startup.write("* Changed Password for: " + username + " from: " + oldPassword + " to: " + newPassword);
    }

    public String getEmailByUsername(String username) throws SQLException {
        String returnUsername = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT email FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnUsername = rs.getString(1);
        }
        return returnUsername;
    }

    public void createTableUsers(){

    }
    public void createTableAdmins(){

    }
    public void createTableAlerts(){

    }

    public void deleteUser(String username) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("DELETE from tokostheatre.users WHERE username='"+ username +"';");
        PreparedStatement stm = con.prepareStatement("DELETE from tokostheatre.ticket WHERE userid='"+ getIdByUser(username) +"';");
//        PreparedStatement st = con.prepareStatement("UPDATE tokostheatre.movies WHERE bought='"+ getIdByUser(username) +"';");
//        getBoughtByUsername()
        //
        stmt.executeUpdate();
        stm.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Deleted Username: '" + username + "' - ");
    }

//    private String getBoughtByUsername(int id) throws SQLException {
//        String bought = null;
//        Connection con = connect();
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT bought FROM tokostheatre.movies WHERE bought = '" + username + "';");
//        while(rs.next()){
//            returnMoney = rs.getDouble(1);
//        }
//        return String.valueOf(returnMoney);
//    }

    public boolean checkUser(String username) {
        boolean existsUsername = false;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select * from tokostheatre.users where username = ? AND type='USER';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(r1.next()) {
                existsUsername = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existsUsername;
    }
    public void changeUsernameByUsername(String from,String to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET username ='"+to + "' WHERE username='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed Username from '" + from + "' to '" + to + "' - ");
        System.out.println(from);
        System.out.println(to);
    }
    public void changeNameByName(String from,String to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET name ='"+to + "' WHERE name='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed Name from '" + from + "' to '" + to + "' - ");
        System.out.println(from);
        System.out.println(to);
    }

    public void changePasswordByUsername(String from, String password) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET password ='"+password + "' WHERE username='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed Password for '" + from + "' to '" + password + "' - ");
        System.out.println(from);
        System.out.println(password);
    }

    public void changeFullNameByPassword(String from, String fullname) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET fullname ='"+fullname + "' WHERE username='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed FullName for '" + from + "' to '" + fullname + "' - ");
        System.out.println(from);
        System.out.println(fullname);
    }

    public void changeEmailByUsername(String from, String email) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET email ='"+email + "' WHERE username='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed Email for '" + from + "' to '" + email + "' - ");
        System.out.println(from);
        System.out.println(email);
    }

    public void changeMoneyByUsername(String from, double money) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET money ="+money + " WHERE username='"+ from +"';");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Changed Money for '" + from + "' to " + money + " - ");
        System.out.println(from);
        System.out.println(money);
    }

    public String getMoneyByUsername(String username) throws SQLException {
        double returnMoney = 0;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT money FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnMoney = rs.getDouble(1);
        }
        return String.valueOf(returnMoney);
    }

    public String getTypeByUsername(String username) throws SQLException {
        String returnType = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT type FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnType = rs.getString(1);
        }
        return returnType;
    }

    public String getTimeByUsername(String username) throws SQLException {
        String returnTime = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT time FROM tokostheatre.users WHERE username = '" + username + "';");
        while(rs.next()){
            returnTime = rs.getString(1);
        }
        return returnTime;
    }

    public void truncate() throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE `tokostheatre.users`");
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# TRUNCATED TABLE uSERS");
    }

    public double getBalanceByUsername(String user) throws SQLException {
        double returnBalance = 0;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT money FROM tokostheatre.users WHERE username = '" + user + "';");
        while(rs.next()){
            returnBalance = rs.getDouble(1);
        }
        return returnBalance;
    }

    public void addMovie(Movie movie) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO tokostheatre.movies values(?,?,?,?,?,?,?,?)");
        stmt.setInt(1,movie.getId());
        stmt.setString(2,movie.getName());
        stmt.setString(3,movie.getDirector());
        stmt.setString(4,movie.getDetails());
        stmt.setDouble(5,movie.getImdb());
        stmt.setString(6,movie.getImage().getUrl());
        stmt.setDouble(7,movie.getPrice());
        stmt.setString(8,movie.getBought());
        //
        stmt.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("* Added Movie: " + movie.getId() + ", " + movie.getName() + ", " + movie.getDirector() + ", " + movie.getDetails()+ ", " + movie.getImage() + ", " + movie.getImage().getUrl().substring(6) + ", " + movie.getPrice() + " - ");
    }

    public boolean checkMovie(int id){
        boolean existsMovie = false;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select * from tokostheatre.movies where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(r1.next()) {
                existsMovie = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existsMovie;
    }
    public Movie getMovieById(int id) throws SQLException {
        Movie returnMovie = new Movie();
        String name = null;
        String director = null;
        String details = null;
        double imdb = 0;
        String address = null;
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tokostheatre.movies where id=" + id);
        while (rs.next()){
            returnMovie.setId(rs.getInt(1));
            returnMovie.setName(rs.getString(2));
            returnMovie.setDirector(rs.getString(3));
            returnMovie.setDetails(rs.getString(4));
            returnMovie.setImdb(rs.getDouble(5));
            Image image = new Image(rs.getString(6));
            returnMovie.setImage(image);
            returnMovie.setPrice(rs.getDouble(7));
            returnMovie.setBought(rs.getString(8));
        }
        return returnMovie;
//        while(rs.next()){
//            returnBalance = rs.getDouble(1);
//        }
//        return returnBalance;
    }

    public int getIdByUser(String user){
        int id = -1;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select id from tokostheatre.users where username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setString(1, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(r1.next()){
                id = r1.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public String getBought(int movieid){
        String bought = null;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select bought from tokostheatre.movies where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setInt(1, movieid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(r1.next()){
                bought = r1.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bought;
    }
    public void buyTicket(int movieid, String user) throws SQLException {
        String oldBought = getBought(movieid);
        int userId = getIdByUser(user);
        oldBought = oldBought + " " + userId;
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET bought ='"+oldBought + "' WHERE id="+ movieid +";");
        PreparedStatement stm = con.prepareStatement("INSERT INTO ticket values(?,?,?)");
        stm.setInt(1,getIdByUser(user));
        stm.setInt(2,movieid);
        Date date = new java.util.Date();
        stm.setString(3, "" + new Date());
        //
        stmt.executeUpdate();
        stm.executeUpdate();
    }

    public boolean checkUserMovie(String user, Movie movie) {
//        String bought = getBought(movie.getId());
//        if(bought==null)return false;
//        else if(bought.contains(" " + getIdByUser(user))){
//            return true;
//        }
//        return false;
        boolean bought = false;
        connect();
        PreparedStatement st = null;
        try {
            st = connect().prepareStatement("select movieid from tokostheatre.ticket where userid = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.setInt(1, getIdByUser(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r1= null;
        try {
            r1 = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("asd");
            while (r1.next()) {//movie ied
                if(r1.getInt(1)==movie.getId()){
                    bought = true;
                }
                System.out.println(r1.getInt(1));
            }
            System.out.println("asd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bought;
    }
    public void setMoneyById(int id,double money) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.users SET money ="+money + " WHERE id="+ id +";");
        //
        stmt.executeUpdate();
    }

    public Movie getMovieByName(String name) throws SQLException {
        Movie returnMovie = new Movie();
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tokostheatre.movies where name='" + name + "';");
        while (rs.next()){
            returnMovie.setId(rs.getInt(1));
            returnMovie.setName(rs.getString(2));
            returnMovie.setDirector(rs.getString(3));
            returnMovie.setDetails(rs.getString(4));
            returnMovie.setImdb(rs.getDouble(5));
            Image image = new Image(rs.getString(6));
            returnMovie.setImage(image);
            returnMovie.setPrice(rs.getDouble(7));
            returnMovie.setBought(rs.getString(8));
        }
        return returnMovie;
    }
    public void changeIdById(int from, int to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET id ="+to + " WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }

    public void changeNameById(int from, String to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET name ='"+to + "' WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }

    public void changeDirectorById(int from, String to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET director ='"+to + "' WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }
    public void changePriceById(int from, double to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET price ="+to + " WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }

    public void changeImdbById(int from, double to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET imdb ="+to + " WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }

    public void changeDetailsById(int from, String to) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("UPDATE tokostheatre.movies SET details ='"+to + "' WHERE id="+ from +";");
        //
        stmt.executeUpdate();
    }

    public void clearTicketsById(int searchId) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("DELETE from tokostheatre.movies where id=" + searchId + ";");
        PreparedStatement stm = con.prepareStatement("DELETE from tokostheatre.ticket where movieid=" + searchId + ";");
        //
        stmt.executeUpdate();
        stm.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Cleared Tickets for " + searchId + " - ");
    }

    public void deleteMovie(int parseInt) throws SQLException {
        Connection con = connect();
        PreparedStatement stmt = con.prepareStatement("DELETE from tokostheatre.movies WHERE id="+ parseInt +";");
        PreparedStatement stm = con.prepareStatement("DELETE from tokostheatre.ticket WHERE movieid="+ parseInt +";");
        //
        stmt.executeUpdate();
        stm.executeUpdate();
        java.util.Date date = new java.util.Date();
        Startup startup = new Startup();
        startup.write("# Deleted Movie: '" + parseInt + "' - ");
    }


//    public void checkUserMovie(int movieid, String user) {//get id by user get
//        String boughts = null;
//        connect();
//        PreparedStatement st = null;
//        try {
//            st = connect().prepareStatement("select bought from tokostheatre.movies where username = ?");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            st.setString(1, user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ResultSet r1= null;
//        try {
//            r1 = st.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            id = r1.getInt(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
}
