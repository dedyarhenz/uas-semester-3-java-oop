package com.company;

public interface Operasi_data {
    void simpanData(String nama, String format, int ukuran);
    void hapusData(int urutan);
    void lihatSemuaData();
    int jumlahData();
}
