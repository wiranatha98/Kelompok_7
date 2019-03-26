package com.example.edulib;

/**
 * Created by abdalla on 1/12/18.
 */

public class UnivData {

    private String UnivName;
    private int UnivImage;
    private String UnivDescription;

    public UnivData(String UnivName,String UnivDescription, int UnivImage) {
        this.UnivName = UnivName;
        this.UnivImage = UnivImage;
        this.UnivDescription = UnivDescription;
    }

    public String getUnivName() {
        return UnivName;
    }


    public int getUnivImage() {
        return UnivImage;
    }

    public String getUnivDescription() {
        return UnivDescription;
    }
}
