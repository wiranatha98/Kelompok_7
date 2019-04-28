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

    String pertanyaan, saran;

    public List_saran(String pertanyaan, String saran) {
        this.pertanyaan = pertanyaan;
        this.saran = saran;
    }


}
