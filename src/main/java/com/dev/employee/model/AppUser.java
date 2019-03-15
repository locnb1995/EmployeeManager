package com.dev.employee.model;

public class AppUser {

    private Long user_id;
    private String username;
    private String encryt_password;
    private String role;

    public AppUser(Long user_id, String username, String encryt_password, String role) {
        this.user_id = user_id;
        this.username = username;
        this.encryt_password = encryt_password;
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryt_password() {
        return encryt_password;
    }

    public void setEncryt_password(String encryt_password) {
        this.encryt_password = encryt_password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
