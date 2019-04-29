package com.example.edulib;

public class List {
    String perihal, keluhan,nama;

    public List(String perihal, String keluhan, String nama) {
        this.perihal = perihal;
        this.keluhan = keluhan;
        this.nama = nama;
    }

    public List(String perihal, String keluhan) {
        this.perihal = perihal;
        this.keluhan = keluhan;
        this.nama = "Anonim";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
