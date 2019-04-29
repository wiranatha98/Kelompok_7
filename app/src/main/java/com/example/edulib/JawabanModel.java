package com.example.edulib;

public class JawabanModel {

    private String jurusan;
    private String SID;
    private String jawaban;

    public JawabanModel(){}

    public JawabanModel(String jurusan, String SID, String jawaban) {
        this.jurusan = jurusan;
        this.SID = SID;
        this.jawaban = jawaban;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getSID() {
        return SID;
    }

    public String getJawaban() {
        return jawaban;
    }
}
