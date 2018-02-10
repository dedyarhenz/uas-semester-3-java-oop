package com.company;

import java.util.ArrayList;
import java.util.List;

public class Laptop extends komputer implements Operasi_data{
    private ArrayList<Data> data_lap = new ArrayList<Data>();

    public Laptop(String nama_komputer, String operating_system, int ram, int speed_processor, int vga, int hdd) {
        super(nama_komputer, operating_system, ram, speed_processor, vga, hdd, "Laptop");
    }

    @Override
    public void spesifikasi() {
        System.out.println("nama laptop : "+getNama_komputer()+
                        "\noperating system : "+getOperating_system()+
                        "\njenis : "+getJenis()+
                        "\nspeed processor : "+getSpeed_processor()+" Ghz"+
                        "\nram : "+getRam()+" GB"+
                        "\nvga : "+getVga()+" GB"+
                        "\nhdd : "+getHdd()+" MB");
    }

    @Override
    public void simpanData(String nama, String format, int ukuran) {
        Data dataku = new Data(nama,format,ukuran);
        if((dataku.getUkuran()+jumlahData())>(getHdd())){
            System.out.println("penyimapan tidak cukup");
        }else{
            data_lap.add(dataku);
            System.out.println("data tersimpan");
        }

    }

    @Override
    public void hapusData(int urutan) {
        if(data_lap.isEmpty()){
            System.out.println("data kosong");
        }else{
            if(urutan>data_lap.size()){
                System.out.println("urutan data tidak ada");
            }else{
                data_lap.remove(urutan-1);
                System.out.println("data berhasil dihapus");
            }
        }

    }

    @Override
    public void lihatSemuaData() {
        if(data_lap.isEmpty()){
            System.out.println("data kosong");
        }else{
            for(int a=0;a<data_lap.size();a++){
                System.out.println("data ke "+(a+1));
                System.out.println("nama data : "+data_lap.get(a).getNama());
                System.out.println("format data : "+data_lap.get(a).getFormat());
                System.out.println("ukuran data : "+data_lap.get(a).getUkuran()+" MB");
                System.out.println();
            }
        }

    }

    @Override
    public int jumlahData() {
        int data_dihdd=0;

        if (data_lap.isEmpty()){
            return 0;
        }else{
            for(int a=0;a<data_lap.size();a++) {
                data_dihdd += data_lap.get(a).getUkuran();
            }
            return data_dihdd;
        }

    }

    public ArrayList<Data> getData_lap() {
        return data_lap;
    }


}
