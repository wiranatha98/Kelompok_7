package com.example.edulib.SaranKeluhan;

public class SaranKeluhan {
    String perihal, keluhan, namaUser;

    public SaranKeluhan(String perihal, String keluhan, String namaUser) {
        this.perihal = perihal;
        this.keluhan = keluhan;
        this.namaUser = namaUser;
    }

    public SaranKeluhan(String perihal, String keluhan) {
        this.perihal = perihal;
        this.keluhan = keluhan;
        this.namaUser = "Anonim";
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

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }
}
