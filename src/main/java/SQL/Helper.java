package SQL;

import java.sql.SQLException;

public class Helper {
    public boolean signin(String username, String password) throws SQLException {
        SqlConfiguration sql = new SqlConfiguration();
        String getPassword = sql.getPasswordByUsername(username);
        return password.equals(getPassword);
    }
    public boolean adminsignin(String username, String password) throws SQLException {
        SqlConfiguration sql = new SqlConfiguration();
        String getPassword = sql.adminGetPasswordByUsername(username);
        return password.equals(getPassword);
    }
    public boolean recover(String username, String email) throws SQLException {
        SqlConfiguration sql = new SqlConfiguration();
        String getEmail = sql.getEmailByUsername(username);
        return email.equals(getEmail);
    }
    public boolean reset(String password, String repeatPassword){
        return repeatPassword.equals(password);
    }
}
