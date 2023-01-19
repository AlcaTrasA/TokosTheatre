package Models;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private double money;
    private String time;
    private UserType type;

    public User(String username, String password, String fullname, String email, double money,UserType type) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.money = money;
        this.time = String.valueOf(new Date());
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
