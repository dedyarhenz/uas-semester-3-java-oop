package com.company;

public class Data {
    private String nama;
    private String format;
    private int ukuran;

    public Data(String nama, String format, int ukuran) {
        this.nama = nama;
        this.format = format;
        this.ukuran = ukuran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getUkuran() {
        return ukuran;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }
}
