package com.example.edulib;

class MateriData_Ips {

    private String MateriName;
    private int MateriImage;
    private String MateriDescription;

    public MateriData_Ips(String MateriName, String MateriDescription, int MateriImage) {
        this.MateriName = MateriName;
        this.MateriImage = MateriImage;
        this.MateriDescription = MateriDescription;
    }
    public int getUnivImage() {
        return MateriImage;
    }

    public CharSequence getUnivName() {
        return MateriName;
    }

    public String getUnivDescription() {
        return MateriDescription;
    }
}
