package com.rollingstone.model;

import com.rollingstone.password.PasswordAlgorithm;
import jakarta.persistence.*;

@Entity
@Table(name="APP_USER")
public class AppUser {
    @Id
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private PasswordAlgorithm algorithm;
    private String roles; // comma-separated (e.g., "USER,ADMIN")

    public AppUser() {
    }

    public AppUser(String username, String password, PasswordAlgorithm algorithm, String roles) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
        this.roles = roles;
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

    public PasswordAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(PasswordAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", algorithm=" + algorithm +
                ", roles='" + roles + '\'' +
                '}';
    }
}

