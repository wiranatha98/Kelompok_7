package com.example.edulib;

/**
 * Created by abdalla on 1/12/18.
 */

public class UnivData {

    private String UnivName;
    private int UnivImage;

    public UnivData(String UnivName, int UnivImage) {
        this.UnivName = UnivName;
        this.UnivImage = UnivImage;
    }

    public String getUnivName() {
        return UnivName;
    }


    public int getUnivImage() {
        return UnivImage;
    }
}
