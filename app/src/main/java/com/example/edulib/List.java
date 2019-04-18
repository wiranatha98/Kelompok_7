package com.example.edulib;

public class List {
    String perihal, keluhan;

    public List(String perihal, String keluhan) {
        this.perihal = perihal;
        this.keluhan = keluhan;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
