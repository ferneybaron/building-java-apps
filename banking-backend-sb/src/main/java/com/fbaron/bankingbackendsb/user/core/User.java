package com.fbaron.bankingbackendsb.user.core;

//Add getter setter default and argument constructor
public class User {
    private String username;
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String toString() {
        return "User( username: " + username + ", password: [PROTECTED] )";
    }
}
