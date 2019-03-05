package com.example.edulib;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class User {
    public String f_name;
    public String l_name;
    public String username;
    public String password;
// ...


    public User(String f_name, String l_name, String username, String password) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
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
