package com.company;

import java.util.ArrayList;

public class Netbook extends komputer implements Operasi_data {
    private ArrayList<Data> data_Net = new ArrayList<Data>();

    public Netbook(String nama_komputer, String operating_system, int ram, int speed_processor, int vga, int hdd) {
        super(nama_komputer, operating_system, ram, speed_processor, vga, hdd, "Netbook");
    }

    @Override
    public void spesifikasi() {
        System.out.println("nama Netbook : "+getNama_komputer()+
                        "\noperating system : "+getOperating_system()+
                        "\nspeed processor : "+getSpeed_processor()+" Ghz"+
                        "\njenis : "+getJenis()+
                        "\nram : "+getRam()+" GB"+
                        "\nvga : "+getVga()+" GB"+
                        "\nhdd : "+getHdd()+" MB");
    }

    @Override
    public void simpanData(String nama, String format, int ukuran) {
        Data dataku = new Data(nama,format,ukuran);
        if((dataku.getUkuran()+jumlahData())>(getHdd()*1000)){
            System.out.println("penyimpanan tidak cukup");
        }else{
            data_Net.add(dataku);
            System.out.println("data tersimpan");
        }

    }

    @Override
    public void hapusData(int urutan) {
        if(data_Net.isEmpty()){
            System.out.println("data kosong");
        }else{
            if(urutan>data_Net.size()){
                System.out.println("urutan data tidak ada");
            }else {
                data_Net.remove(urutan - 1);
                System.out.println("data berhasil dihapus");
            }
        }

    }

    @Override
    public void lihatSemuaData() {
        if(data_Net.isEmpty()){
            System.out.println("data kosong");
        }else{
            for(int a=0;a<data_Net.size();a++){
                System.out.println("data ke "+(a+1));
                System.out.println("nama data : "+data_Net.get(a).getNama());
                System.out.println("format data : "+data_Net.get(a).getFormat());
                System.out.println("ukuran data : "+data_Net.get(a).getUkuran()+" MB");
                System.out.println();
            }
        }

    }

    @Override
    public int jumlahData() {
        int data_dihdd=0;

        if (data_Net.isEmpty()){
            return 0;
        }else{
            for(int a=0;a<data_Net.size();a++) {
                data_dihdd += data_Net.get(a).getUkuran();
            }
            return data_dihdd;
        }
    }

    public ArrayList<Data> getData_Net() {
        return data_Net;
    }
}
