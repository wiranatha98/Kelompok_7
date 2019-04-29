package com.example.edulib;

public class Pengguna {
    private String name;

    public Pengguna(String name) {
        this.name = name;
    }

    public Pengguna(String fname, String lname) {
        this.name = fname+" "+lname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
