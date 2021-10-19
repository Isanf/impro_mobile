package com.supernettechnologie.impromobile.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String username;
    private String password;
    private String rememberMe;

    public LoggedInUser(String username, String password, String rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRememberMe() {
        return rememberMe;
    }
}
