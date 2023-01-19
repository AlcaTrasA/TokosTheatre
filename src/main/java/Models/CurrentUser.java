package Models;

public class CurrentUser {
    private String username;
    private String password;

    public CurrentUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
