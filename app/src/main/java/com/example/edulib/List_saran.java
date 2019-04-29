package com.example.edulib;

public class List_saran {
    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    String pertanyaan, saran,nama;

    public List_saran(String pertanyaan, String saran, String nama) {
        this.pertanyaan = pertanyaan;
        this.saran = saran;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List_saran(String pertanyaan, String saran) {
        this.pertanyaan = pertanyaan;
        this.saran = saran;
        this.nama = "Anonim";
    }


}
