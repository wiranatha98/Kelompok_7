package com.example.edulib;

public class SoalModel {

    private String SID;
    private String jurusan;
    private String imagepath;
    private String textSoal;
    private String opsiA;
    private String opsiB;
    private String opsiC;
    private String opsiD;
    private String kunciJawaban;

    public SoalModel(){}

    public SoalModel(
            String jurusan, String imagepath, String textSoal,
            String opsiA, String opsiB, String opsiC, String opsiD, String kunciJawaban
    ) {
      this.jurusan = jurusan;
      this.imagepath = imagepath;
      this.textSoal = textSoal;
      this.opsiA = opsiA;
      this.opsiB = opsiB;
      this.opsiC = opsiC;
      this.opsiD = opsiD;
      this.kunciJawaban = kunciJawaban;
    }

    public SoalModel(
            String SID, String jurusan, String imagepath, String textSoal,
            String opsiA, String opsiB, String opsiC, String opsiD, String kunciJawaban
    ) {
        this.SID = SID;
        this.jurusan = jurusan;
        this.imagepath = imagepath;
        this.textSoal = textSoal;
        this.opsiA = opsiA;
        this.opsiB = opsiB;
        this.opsiC = opsiC;
        this.opsiD = opsiD;
        this.kunciJawaban = kunciJawaban;
    }

    public String getSID() {
        return SID;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String getTextSoal() {
        return textSoal;
    }

    public String getOpsiA() {
        return opsiA;
    }

    public String getOpsiB() {
        return opsiB;
    }

    public String getOpsiC() {
        return opsiC;
    }

    public String getOpsiD() {
        return opsiD;
    }

    public String getKunciJawaban() {
        return kunciJawaban;
    }
}
