package com.example.edulib;

public class ipsData {
    private String ipsName;
    private int ipsImage;
    private String ipsDescription;

    public ipsData(String ipsName,String ipsDescription, int ipsImage) {
        this.ipsName = ipsName;
        this.ipsImage = ipsImage;
        this.ipsDescription = ipsDescription;
    }

    public String getipsName() {
        return ipsName;
    }


    public int getipsImage() {
        return ipsImage;
    }

    public String getipsDescription() {
        return ipsDescription;
    }
}
