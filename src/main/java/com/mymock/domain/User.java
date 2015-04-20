package com.mymock.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rkavya on 3/24/2015.
 */
@Entity
public class User {

    @Id
    private String username;

    private String password;

    public User() {
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
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
