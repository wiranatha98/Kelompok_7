package com.example.edulib;

public class bahasaData {
    private String bahasaName;
    private int bahasaImage;
    private String bahasaDescription;

    public bahasaData(String bahasaName,String bahasaDescription, int bahasaImage) {
        this.bahasaName = bahasaName;
        this.bahasaImage = bahasaImage;
        this.bahasaDescription = bahasaDescription;
    }

    public String getbahasaName() {
        return bahasaName;
    }


    public int getbahasaImage() {
        return bahasaImage;
    }

    public String getbahasaDescription() {
        return bahasaDescription;
    }
}
