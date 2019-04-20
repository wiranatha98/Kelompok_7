package com.example.edulib;

/**
 *
 */

public class MateriData {

    private String MateriName;
    private int MateriImage;
    private String MateriDescription;

    public MateriData(String MateriName, String MateriDescription, int MateriImage) {
        this.MateriName = MateriName;
        this.MateriImage = MateriImage;
        this.MateriDescription = MateriDescription;
    }

    public String getUnivName() {
        return MateriName;
    }


    public int getUnivImage() {
        return MateriImage;
    }

    public String getUnivDescription() {
        return MateriDescription;
    }
}
