package com.example.edulib;

public class ipaData {
    private String ipaName;
    private int ipaImage;
    private String ipaDescription;

    public ipaData(String ipaName,String ipaDescription, int ipaImage) {
        this.ipaName = ipaName;
        this.ipaImage = ipaImage;
        this.ipaDescription = ipaDescription;
    }

    public String getipaName() {
        return ipaName;
    }


    public int getipaImage() {
        return ipaImage;
    }

    public String getipaDescription() {
        return ipaDescription;
    }
}
